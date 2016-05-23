package com.example.iuris.ustglobalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

/**
 * Created by Ernesto Mediavilla on 23/05/2016.
 * Edited by Miguel Rodríguez on 23/05/2016
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buscar;
    private EditText textoBusqueda;
    private static final int PHONE_CALL = 0;
    Intent callIntent, emailIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buscar = (Button)findViewById(R.id.buscar);
        textoBusqueda = (EditText)findViewById(R.id.textoBusqueda);

    }

    @Override
    public void onClick(View v) {

        int identificador;
        identificador = v.getId();
        TextView tv = (TextView) this.findViewById(identificador);
        String datosDestino = (String) tv.getText();
        call(tv);
        //mail(tv);

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


    public void buscar(View v){

        Intent intent = new Intent(this, BusquedaActivity.class);

        startActivity(intent);



    }

    //Paso 1. Verificar permiso
    private boolean verifyCallPermission() {

        //CALL_PHONE tiene implícitos READ_PHONE_STATE, READ_CALL_LOG, WRITE_CALL_LOG,
        // ADD_VOICEMAIL, USE_SIP y PROCESS_OUTGOING_CALLS porque pertenecen al mismo
        //grupo de permisos

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
