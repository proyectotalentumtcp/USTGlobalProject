package com.iuriX.ustglobalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import controlador.AdaptadorUsuario;

import java.util.ArrayList;
import java.util.List;

import modelo.busqueda.ListaEmpleados;
import modelo.login.R;
import modelo.Usuario;


public class BusquedaActivity extends Activity {

    private RecyclerView listaUsuarios;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager lManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        listaUsuarios = (RecyclerView) findViewById(R.id.listaUsuarios);
        listaUsuarios.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        listaUsuarios.setLayoutManager(lManager);

        ListaEmpleados listaEmpleados = (ListaEmpleados)getIntent().getSerializableExtra("empleados");


        adaptador = new AdaptadorUsuario(listaEmpleados.getListaUsuarios());
        listaUsuarios.setAdapter(adaptador);

    }


}


