package com.iuriX.ustglobalproject;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
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
import android.os.Handler;

import com.iuriX.ustglobalproject.facetracker.FaceTrackerActivity;

public class MainActivity extends Activity {


    private Button buscar;
    private EditText textoBusqueda;
    private BusquedaInterface service;
    LinearLayout logout;
    ImageView imageUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buscar = (Button)findViewById(R.id.buscar);
        textoBusqueda = (EditText)findViewById(R.id.textoBusqueda);
        logout = (LinearLayout)findViewById(R.id.logout);
        imageUsuario = (ImageView) findViewById(R.id.imageUsuario);

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

    public void buscar(View v){

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.api_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(BusquedaInterface.class);

        textoBusqueda.setError(null);

        boolean cancel = false;
        View focusView = null;

        final PeticionBusquedaJSON peticionBusquedaJSON = new PeticionBusquedaJSON();

        peticionBusquedaJSON.setBusqueda(textoBusqueda.getText().toString());
        peticionBusquedaJSON.setSessionId(Session.getInstance().getSessionId());

        Call<ListaEmpleados> listaEmpleadosCall = service.getListaEmpleados(peticionBusquedaJSON);
        listaEmpleadosCall.enqueue(new Callback<ListaEmpleados>() {
            @Override
            public void onResponse(Call<ListaEmpleados> call, Response<ListaEmpleados> response) {
                progressDialog.dismiss();

                int statusCode = response.code();

                ListaEmpleados listaEmpleados1 = response.body();

                //Session.getInstance().setId_empleado_seleccionado(listaEmpleados1.empleados.get().getId());

                if (listaEmpleados1.getListaUsuarios().size() > 0) {

                    Log.d("MainActivity", "onResponse" + statusCode + " " + listaEmpleados1);

                    Intent intentBusqueda = new Intent(MainActivity.this, BusquedaActivity.class);

                    Session.getInstance().setListaEmpleadosSession(listaEmpleados1);

                    startActivity(intentBusqueda);
                    findViewById(R.id.loadingPanel).setVisibility(View.GONE);

                } else {

                    Toast.makeText(MainActivity.this, "Criterios no encontrados", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListaEmpleados> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Error de conexión con el servidor",Toast.LENGTH_SHORT).show();
                Log.d("LoginActivity", "onFailure: " + t.getMessage());

            }
        });
    }

    public void buscarFoto(View view) {
        //testeando...
        Intent fotoSearch = new Intent(getApplicationContext(), FaceTrackerActivity.class);
        startActivity(fotoSearch);
    }

    boolean twice;
    @Override
    public void onBackPressed() {

        Log.d("MainActivity","click");

        if (twice == true) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
        twice = true;
        Log.d("MainActivity", "twice: " + twice);

       Toast.makeText(MainActivity.this,"Presiona ATRÁS de nuevo para salir", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
                Log.d("MainActivity", "twice: " + twice);
            }
        },3000);
    }
}
