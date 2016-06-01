package com.iuriX.ustglobalproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import android.os.Handler;


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
    LinearLayout logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buscar = (Button)findViewById(R.id.buscar);
        textoBusqueda = (EditText)findViewById(R.id.textoBusqueda);
        logout = (LinearLayout)findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Session.getInstance().setSessionId("");
                Intent logout = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(logout);
            }
        });
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
            cancel = true; //cancelado para aligerar testea
        }

        if (cancel){
            focusView.requestFocus();
        }else{
            final PeticionBusquedaJSON peticionBusquedaJSON = new PeticionBusquedaJSON();
            final ListaEmpleados listaEmpleados = new ListaEmpleados();

            peticionBusquedaJSON.setBusqueda(textoBusqueda.getText().toString());
            peticionBusquedaJSON.setSessionId(Session.getInstance().getSessionId());


            Call<ListaEmpleados> listaEmpleadosCall = service.getListaEmpleados(peticionBusquedaJSON);
            listaEmpleadosCall.enqueue(new Callback<ListaEmpleados>() {
                @Override
                public void onResponse(Call<ListaEmpleados> call, Response<ListaEmpleados> response) {

                    int statusCode = response.code();

                    ListaEmpleados listaEmpleados1 = response.body();

                    //Session.getInstance().setId_empleado_seleccionado(listaEmpleados1.empleados.get().getId());

                    if (listaEmpleados1.getListaUsuarios().size() > 0) {

                        Log.d("MainActivity", "onResponse" + statusCode + " " + listaEmpleados1);

                        Intent intentBusqueda = new Intent(MainActivity.this, BusquedaActivity.class);

                        Session.getInstance().setListaEmpleadosSession(listaEmpleados1);

                        startActivity(intentBusqueda);

                    } else {

                        Toast.makeText(MainActivity.this, "Lista de empleados vacía", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ListaEmpleados> call, Throwable t) {

                    Log.d("LoginActivity", "onFailure: " + t.getMessage());

                }
            });
        }
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
