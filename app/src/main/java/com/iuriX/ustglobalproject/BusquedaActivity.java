package com.iuriX.ustglobalproject;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import controlador.AdaptadorUsuario;
import modelo.Session;
import modelo.busqueda.BusquedaInterface;
import modelo.busqueda.ListaEmpleados;
import modelo.busqueda.PeticionBusquedaJSON;
import modelo.login.LoginActivity;
import modelo.login.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.iuriX.ustglobalproject.DetalleActivity;

public class BusquedaActivity extends Activity {

    private RecyclerView listaUsuarios;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager lManager;
    private TextView buscarBusqueda;
    private BusquedaInterface service;
    LinearLayout logout;
    ImageView imageUsuario;
    private static final int PHONE_CALL = 0;
    Intent callIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        listaUsuarios = (RecyclerView) findViewById(R.id.listaUsuarios);
        listaUsuarios.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        listaUsuarios.setLayoutManager(lManager);

        imageUsuario = (ImageView)findViewById(R.id.imageUsuario);


        adaptador = new AdaptadorUsuario(Session.getInstance().getListaEmpleadosSession());
        listaUsuarios.setAdapter(adaptador);

        buscarBusqueda = (TextView)findViewById(R.id.buscarBusqueda);

        logout = (LinearLayout)findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Session.getInstance().setSessionId("");
                Intent logout = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(logout);
            }
        });

        if(Session.getInstance().getImagenBase64().equals("")){
            Log.d("MainActivity", "Imagen vacía");

        }else {
            byte[] decodedString = Base64.decode(Session.getInstance().getImagenBase64().getBytes(), Base64.URL_SAFE);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            imageUsuario.setImageBitmap(decodedByte);
        }


    }

    public void llamar(String st) { //hay que ver cómo llamar a la función call(st) de DetalleActivity
        //DetalleActivity.call(st);
        callB(st);
    }

    //Función de llamada
    public void callB(String ST) {
        Log.i("estamos","en llamada");
        callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + ST));
        if (Build.VERSION.SDK_INT < 23) {
            startActivity(callIntent); //hasta la API 22
        } else {
            if (verifyCallPermission()) {
                startActivity(callIntent); //ya tiene permisos
            } else {
                requestPermission();
            }
        }
    }

    //Paso 1. Verificar permisos
    public boolean verifyCallPermission() {

        // CALL_PHONE tiene implícitos READ_PHONE_STATE, READ_CALL_LOG, WRITE_CALL_LOG,
        // ADD_VOICEMAIL, USE_SIP y PROCESS_OUTGOING_CALLS porque pertenecen al mismo
        // grupo de permisos

        int callPermission = checkSelfPermission(Manifest.permission.CALL_PHONE); //no es problema pues solo se llama a partir de la API 23

        if (callPermission != PackageManager.PERMISSION_GRANTED) { //no hay permiso previamente
            return false;
        } else { //ya dimos permiso con anterioridad
            return true;
        }
    }

    //Paso 2: Solicitar permiso
    private void requestPermission() { //hasta aquí llega bien
        //shouldShowRequestPermissionRationale es verdadero solamente si ya se había mostrado
        //anteriormente el dialogo de permisos y el usuario lo negó

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},PHONE_CALL); //no es problema pues solo se llama a partir de la API 23
            Log.i("Caso: ","Permisos previamente negados");
        } else {
            //y falso si es la primera vez se solicita el permiso directamente
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},PHONE_CALL); //no es problema pues solo se llama a partir de la API 23
            Log.i("Caso: ","Petición de permisos por primera vez");
        }
    }

    //Paso 3: Procesar respuesta de usuario
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //Si el requestCode corresponde al que usamos para solicitar el permiso y
        //la respuesta del usuario fue positiva
        //if (requestCode == PHONE_CALL) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.i("Respuesta: ","Permiso concedido");
            startActivity(callIntent);
        } else {
            Log.i("Respuesta: ","Permiso denegado");
//                showSnackBar();
        }
        //}
    }


    public void buscar(View v){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.api_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(BusquedaInterface.class);

        String busqueda = buscarBusqueda.getText().toString();


            final PeticionBusquedaJSON peticionBusquedaJSON = new PeticionBusquedaJSON();
            final ListaEmpleados listaEmpleados = new ListaEmpleados();

            peticionBusquedaJSON.setBusqueda(buscarBusqueda.getText().toString());
            peticionBusquedaJSON.setSessionId(Session.getInstance().getSessionId());

            Call<ListaEmpleados> listaEmpleadosCall = service.getListaEmpleados(peticionBusquedaJSON);
            listaEmpleadosCall.enqueue(new Callback<ListaEmpleados>() {
                @Override
                public void onResponse(Call<ListaEmpleados> call, Response<ListaEmpleados> response) {

                    int statusCode = response.code();

                    ListaEmpleados listaEmpleados1 = response.body();

                    if (listaEmpleados1.getListaUsuarios().size() > 0) {

                        Toast.makeText(getApplicationContext(), "Cargando..." ,Toast.LENGTH_SHORT).show();

                        Log.d("MainActivity", "onResponse" + statusCode + " " + listaEmpleados1);

                        Intent intentBusqueda = new Intent(BusquedaActivity.this, BusquedaActivity.class);

                        Session.getInstance().setListaEmpleadosSession(listaEmpleados1);

                        finish();
                        startActivity(intentBusqueda);

                    } else {

                        Toast.makeText(BusquedaActivity.this, "Lista de empleados vacía", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<ListaEmpleados> call, Throwable t) {

                    Log.d("LoginActivity", "onFailure: " + t.getMessage());

                }
            });
        }
    }



