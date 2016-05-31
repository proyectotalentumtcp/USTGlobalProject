package com.iuriX.ustglobalproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;

import modelo.Session;
import modelo.busqueda.ListaEmpleados;
import modelo.busqueda.PeticionBusquedaJSON;
import modelo.detalles.DetallesEmpleado;
import modelo.detalles.DetallesInterface;
import modelo.detalles.DetallesJSON;
import modelo.detalles.PeticionDetallesJSON;
import modelo.login.LogEasyApi;
import modelo.login.R;
import modelo.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleActivity extends Activity implements View.OnClickListener { //}, View.OnLongClickListener {

    TextView nombreDetalle;
//    TextView apellido1Detalle;
//    TextView apellido2Detalle;
    TextView apellidosDetalle;
    TextView telefonoMovilDetalle;
    TextView telefonoDirectoDetalle;
    TextView correoDetalle;
    TextView correoAlternativoDetalle;
    TextView direccionDetalle;
    TextView extensionDetalle;
    TextView centralitaDetalle;
    TextView localizacionDetalle;
    TextView areaDetalle;
    TextView empresaDetalle;
    Button agenda;
    private static final int PHONE_CALL = 0;
    Intent callIntent, emailIntent, contactIntent;
    private DetallesInterface service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        nombreDetalle = (TextView)findViewById(R.id.nombreDetalle);
//        apellido1Detalle = (TextView)findViewById(R.id.apellido1Detalle);
//        apellido2Detalle = (TextView)findViewById(R.id.apellido2Detalle);
        apellidosDetalle = (TextView)findViewById(R.id.apellidosDetalle);
        telefonoMovilDetalle = (TextView)findViewById(R.id.telefonoMovilDetalle);
        telefonoDirectoDetalle = (TextView)findViewById(R.id.telefonoDirectoDetalle);
        correoDetalle = (TextView)findViewById(R.id.correoDetalle);
        correoAlternativoDetalle = (TextView)findViewById(R.id.correoAlternativoDetalle);
        direccionDetalle = (TextView)findViewById(R.id.direccionDetalle);
        extensionDetalle = (TextView)findViewById(R.id.extensionDetalle);
        centralitaDetalle = (TextView)findViewById(R.id.centralitaDetalle);
        localizacionDetalle = (TextView)findViewById(R.id.localizacionDetalle);
        areaDetalle = (TextView)findViewById(R.id.areaDetalle);
        empresaDetalle = (TextView)findViewById(R.id.empresaDetalle);
        agenda = (Button)findViewById(R.id.agenda);


        //tv1.setOnClickListener(this);
//        tv1.setOnLongClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.api_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(DetallesInterface.class);


        final PeticionDetallesJSON peticionDetallesJSON = new PeticionDetallesJSON();
        final DetallesEmpleado detallesEmpleado = new DetallesEmpleado();

        peticionDetallesJSON.setIdEmpleado(Session.getInstance().getId_empleado_seleccionado());
        Log.i("empleado seleccionado",String.valueOf(Session.getInstance().getId_empleado_seleccionado()));
        peticionDetallesJSON.setSessionId(Session.getInstance().getSessionId());


            Call<DetallesJSON> detallesJSONCall = service.getDetallesEmpleado(peticionDetallesJSON);
            detallesJSONCall.enqueue(new Callback<DetallesJSON>() {


                @Override
                public void onResponse(Call<DetallesJSON> call, Response<DetallesJSON> response) {

                    int statusCode = response.code();
                    DetallesJSON detallesEmpleado1 = response.body();

                    Log.d("MainActivity", "onResponse" + statusCode + " " + detallesEmpleado1);

                    nombreDetalle.setText(detallesEmpleado1.getNombre());
                    apellidosDetalle.setText(detallesEmpleado1.getApellidos());
                    telefonoMovilDetalle.setText(detallesEmpleado1.getTelefonoMovil());
                    telefonoDirectoDetalle.setText(detallesEmpleado1.getTelefonoDirecto());
                    correoDetalle.setText(detallesEmpleado1.getCorreo());
                    correoAlternativoDetalle.setText(detallesEmpleado1.getCorreoAlternativo());
                    direccionDetalle.setText(detallesEmpleado1.getDireccion());
                    extensionDetalle.setText(detallesEmpleado1.getExtension());
                    centralitaDetalle.setText(detallesEmpleado1.getCentralita());
                    localizacionDetalle.setText(detallesEmpleado1.getLocalizacion());
                    areaDetalle.setText(detallesEmpleado1.getArea());
                    empresaDetalle.setText(detallesEmpleado1.getEmpresa());

                    Session.getInstance().setDetallesEmpleadoSession(detallesEmpleado);

                }

                @Override
                public void onFailure(Call<DetallesJSON> call, Throwable t) {

                    Toast.makeText(DetalleActivity.this, "Detalles vacios", Toast.LENGTH_SHORT).show();

                }

            });

    }


    @Override
    public void onClick(View v) {

        int identificador;
        identificador = v.getId();
        TextView tv = (TextView) this.findViewById(identificador);

        if (v.getTag().toString().equals("Llamar")) {
            Log.i("ShortClick","call");
            //Toast.makeText(getApplicationContext(), "ShortClick_call", Toast.LENGTH_SHORT).show();
            call(tv);
        } else if (v.getTag().toString().equals("EnviarCorreo")) {
            Log.i("ShortClick","mail");
            //Toast.makeText(getApplicationContext(), "ShortClick_mail", Toast.LENGTH_SHORT).show();
            mail(tv);
        } else if (v.getTag().toString().equals("Ubicar")) {
            Log.i("ShortClick","map");
            //Toast.makeText(getApplicationContext(), "ShortClick_save", Toast.LENGTH_SHORT).show();
            map(tv);
        }else if (v.getTag().toString().equals("GuardarContacto")) {
            Log.i("ShortClick","save");
            //Toast.makeText(getApplicationContext(), "ShortClick_save", Toast.LENGTH_SHORT).show();
            memorizar(tv);
        }
    }

/*    @Override
    public boolean onLongClick(View v) {

        int identificador;
        identificador = v.getId();
        TextView tv = (TextView) this.findViewById(identificador);

        Log.i("LongClick","ok");
        // TODO Auto-generated method stub
        Toast.makeText(getApplicationContext(), "LongClick", Toast.LENGTH_SHORT).show();
        memorizar(tv);
        return true;
    }*/

    private void memorizar(TextView tv){
        CharSequence Nombre = nombreDetalle.getText();
//        CharSequence Apellido1 = apellido1Detalle.getText();
//        CharSequence Apellido2 = apellido2Detalle.getText();
        CharSequence Apellidos = apellidosDetalle.getText();
        CharSequence TelefonoMovil = telefonoMovilDetalle.getText();
        CharSequence TelefonoDirecto = telefonoDirectoDetalle.getText();
        CharSequence Correo = correoDetalle.getText();
        CharSequence CorreoAlternativo = correoAlternativoDetalle.getText();
        CharSequence Direccion = direccionDetalle.getText();

        contactIntent = new Intent(Intent.ACTION_INSERT);
        contactIntent.setType(ContactsContract.Contacts.CONTENT_TYPE);
//        contactIntent.putExtra(ContactsContract.Intents.Insert.NAME, String.valueOf(Nombre) + " " + String.valueOf(Apellido1) + " " + String.valueOf(Apellido2));
        contactIntent.putExtra(ContactsContract.Intents.Insert.NAME, String.valueOf(Nombre) + " " + String.valueOf(Apellidos));
        contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, String.valueOf(TelefonoMovil));
        contactIntent.putExtra(ContactsContract.Intents.Insert.SECONDARY_PHONE, String.valueOf(TelefonoDirecto));
        contactIntent.putExtra(ContactsContract.Intents.Insert.EMAIL, String.valueOf(Correo));
        contactIntent.putExtra(ContactsContract.Intents.Insert.SECONDARY_EMAIL, String.valueOf(CorreoAlternativo));
        contactIntent.putExtra(ContactsContract.Intents.Insert.POSTAL, String.valueOf(Direccion));

        startActivity(contactIntent);

    }

    private void mail(TextView tv){
        emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        //emailIntent.setType("text/plain");
        //emailIntent.putExtra(Intent.EXTRA_SUBJECT, "asunto"); //opcional
        //emailIntent.putExtra(Intent.EXTRA_TEXT, "texto del correo"); //opcional
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {(String) tv.getText()}); //ok
        startActivity(emailIntent);
    }

    private void map(TextView tv){ //https://developers.google.com/maps/documentation/android-api/intents#busqueda_categorica
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + tv.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    //Función de llamada
    private void call(TextView tv) {
        callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + tv.getText()));
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
    private boolean verifyCallPermission() {

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

}

