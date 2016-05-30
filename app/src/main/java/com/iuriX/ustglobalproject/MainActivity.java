package com.iuriX.ustglobalproject;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Modelo.Login.R;


/**
 * Created by Ernesto Mediavilla on 23/05/2016.
 * Edited by Miguel Rodríguez on 23/05/2016
 */

public class MainActivity extends Activity {

    public  static final String URL = "ec2-52-19-159-183.eu-west-1.compute.amazonnaws.com:8088/restservices/rest/services/";
    /*Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
*/
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
     /*  final Context context = v.getContext();

        final BusquedaInterface busquedaInterface = retrofit.create(BusquedaInterface.class);

        PeticionBusquedaJSON peticionBusquedaJSON = new PeticionBusquedaJSON(textoBusqueda.getText().toString(), "id_session");
        retrofit2.Call<PeticionBusquedaJSON> call = busquedaInterface.postBusqueda(peticionBusquedaJSON, new Callback<ListaEmpleados>() {
            @Override
            public void onResponse(retrofit2.Call<BusquedaJSON> call, Response<ListaEmpleados> response) {

<<<<<<< HEAD
                BusquedaJSON busquedaJSON = response.body();
*/
              /*  Intent intent = new Intent(this, BusquedaActivity.class);
               // intent.putExtra("empleados",busquedaJSON);

                startActivity(intent);
=======
                ListaEmpleados listaEmpleados = response.body();

                Intent intent = new Intent(context, BusquedaActivity.class);
                intent.putExtra("empleados",listaEmpleados);

                context.startActivity(intent);
>>>>>>> 2b8c362c8ad36efb46511d3fe7c7def8a2f5a918



            }

            @Override
            public void onFailure(retrofit2.Call<ListaEmpleados> call, Throwable t) {

            }
        });*/







        Intent intent = new Intent(this, BusquedaActivity.class);

        startActivity(intent);

    }


}
