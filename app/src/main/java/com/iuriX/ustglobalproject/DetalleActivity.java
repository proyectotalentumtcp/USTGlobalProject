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


import modelo.login.R;
import modelo.Usuario;

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

        Usuario userDetalle = (Usuario)getIntent().getSerializableExtra("usuario");

        nombreDetalle.setText(userDetalle.getNombre());
//        apellido1Detalle.setText(userDetalle.getApellido1());
//        apellido2Detalle.setText(userDetalle.getApellido2());
        apellidosDetalle.setText(userDetalle.getApellidos());
        telefonoMovilDetalle.setText(userDetalle.getTelefonoMovil());
        telefonoDirectoDetalle.setText(userDetalle.getTelefonoDirecto());
        correoDetalle.setText(userDetalle.getCorreo());
        correoAlternativoDetalle.setText(userDetalle.getCorreoAlternativo());
        direccionDetalle.setText(userDetalle.getDireccion());
        extensionDetalle.setText(userDetalle.getExtension());
        centralitaDetalle.setText(userDetalle.getCentralita());
        localizacionDetalle.setText(userDetalle.getLocalizacion());
        areaDetalle.setText(userDetalle.getArea());
        empresaDetalle.setText(userDetalle.getEmpresa());

        //TextView tv1 = (TextView) findViewById(R.id.telefonoDetalle);

        //tv1.setOnClickListener(this);
//        tv1.setOnLongClickListener(this);

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
        } else if (v.getTag().toString().equals("GuardarContacto")) {
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
