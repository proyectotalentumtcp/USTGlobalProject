package com.example.iuris.ustglobalproject;

import android.content.Context;
import android.content.pm.PermissionInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.app.Activity;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import java.io.Serializable;

import Modelo.BusquedaInterface;
import Modelo.BusquedaJSON;
import Modelo.PeticionBusquedaJSON;
import Modelo.Session;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ernesto Mediavilla on 23/05/2016.
 * Edited by Miguel Rodríguez on 23/05/2016
 */

public class MainActivity extends AppCompatActivity {

    public  static final String URL = "ec2-52-19-159-183.eu-west-1.compute.amazonnaws.com:8088/restservices/rest/services/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

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

        //LLamada del servicio REST
       final Context context = v.getContext();

        final BusquedaInterface busquedaInterface = retrofit.create(BusquedaInterface.class);

        PeticionBusquedaJSON peticionBusquedaJSON = new PeticionBusquedaJSON(textoBusqueda.getText().toString(), "id_session");
        retrofit2.Call<PeticionBusquedaJSON> call = busquedaInterface.postBusqueda(peticionBusquedaJSON, new Callback<BusquedaJSON>() {
            @Override
            public void onResponse(retrofit2.Call<BusquedaJSON> call, Response<BusquedaJSON> response) {

                BusquedaJSON busquedaJSON = response.body();

                Intent intent = new Intent(context, BusquedaActivity.class);
                intent.putExtra("empleados",busquedaJSON);

                context.startActivity(intent);



            }

            @Override
            public void onFailure(retrofit2.Call<BusquedaJSON> call, Throwable t) {

            }
        });







        Intent intent = new Intent(this, BusquedaActivity.class);

        startActivity(intent);

    }


}
