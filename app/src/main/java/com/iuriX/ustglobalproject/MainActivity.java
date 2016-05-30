package com.iuriX.ustglobalproject;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import modelo.busqueda.BusquedaInterface;
import modelo.busqueda.ListaEmpleados;
import modelo.busqueda.PeticionBusquedaJSON;
import modelo.login.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import modelo.login.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ernesto Mediavilla on 23/05/2016.
 * Edited by Miguel Rodríguez on 23/05/2016
 */

public class MainActivity extends Activity {


    private Button buscar;
    private EditText textoBusqueda;
    private BusquedaInterface service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buscar = (Button)findViewById(R.id.buscar);
        textoBusqueda = (EditText)findViewById(R.id.textoBusqueda);

    }

    public void buscar(View v){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.api_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(BusquedaInterface.class);

        textoBusqueda.setError(null);

        String busqueda = textoBusqueda.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (busqueda.equals("")){

            textoBusqueda.setError("Campo de busqueda vacío");
            focusView = textoBusqueda;
            cancel = true;

        }

        if (cancel){
            focusView.requestFocus();
        }else{
            final PeticionBusquedaJSON peticionBusquedaJSON = new PeticionBusquedaJSON();
            final ListaEmpleados listaEmpleados = new ListaEmpleados();

            peticionBusquedaJSON.setBusqueda(textoBusqueda.getText().toString());
            //peticionBusquedaJSON.setSessionId(session.getSessionId);

            Call<ListaEmpleados> listaEmpleadosCall = service.getListaEmpleados(peticionBusquedaJSON);
            listaEmpleadosCall.enqueue(new Callback<ListaEmpleados>() {
                @Override
                public void onResponse(Call<ListaEmpleados> call, Response<ListaEmpleados> response) {

                    int statusCode = response.code();

                    ListaEmpleados listaEmpleados1 = response.body();

                    Log.d("MainActivity", "onResponse" + statusCode + " " + listaEmpleados1);


                    Intent intent = new Intent(getApplicationContext(), BusquedaActivity.class);

                    intent.putExtra("empleados", listaEmpleados1);

                    startActivity(intent);



                }

                @Override
                public void onFailure(Call<ListaEmpleados> call, Throwable t) {

                }
            });





        }




    }


}
