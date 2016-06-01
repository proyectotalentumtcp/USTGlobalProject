package com.iuriX.ustglobalproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import controlador.AdaptadorUsuario;
import modelo.Session;
import modelo.busqueda.BusquedaInterface;
import modelo.busqueda.ListaEmpleados;
import modelo.busqueda.PeticionBusquedaJSON;
import modelo.login.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BusquedaActivity extends Activity {

    private RecyclerView listaUsuarios;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager lManager;
    private TextView buscarBusqueda;
    private BusquedaInterface service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        listaUsuarios = (RecyclerView) findViewById(R.id.listaUsuarios);
        listaUsuarios.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        listaUsuarios.setLayoutManager(lManager);



        adaptador = new AdaptadorUsuario(Session.getInstance().getListaEmpleadosSession());
        listaUsuarios.setAdapter(adaptador);

    }
    public void buscar(View v){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.api_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(BusquedaInterface.class);

        //buscarBusqueda.setError(null);

        String busqueda = buscarBusqueda.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (busqueda.equals("")){

            buscarBusqueda.setError("Campo de busqueda vacío");
            focusView = buscarBusqueda;
            //cancel = true; //cancelado para aligerar testea

        }

        if (cancel){
            // Funciona
            focusView.requestFocus();
        }else{
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

                    //Session.getInstance().setId_empleado_seleccionado(listaEmpleados1.empleados.get().getId());

                    if (listaEmpleados1.getListaUsuarios().size() > 0) {

                        Log.d("MainActivity", "onResponse" + statusCode + " " + listaEmpleados1);


                        Session.getInstance().setListaEmpleadosSession(listaEmpleados1);
                        adaptador.notifyDataSetChanged();


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


}


