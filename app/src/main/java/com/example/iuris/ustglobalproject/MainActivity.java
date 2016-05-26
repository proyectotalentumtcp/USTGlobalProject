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

public class MainActivity extends Activity {

    private Button buscar;
    private EditText textoBusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buscar = (Button)findViewById(R.id.buscar);
        textoBusqueda = (EditText)findViewById(R.id.textoBusqueda);

    }

    public void buscar(View v){

        Intent intent = new Intent(this, BusquedaActivity.class);

        startActivity(intent);

    }


}
