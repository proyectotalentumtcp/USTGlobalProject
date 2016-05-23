package com.example.iuris.ustglobalproject;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import com.example.iuris.ustglobalproject.R;

import java.util.ArrayList;
import java.util.List;

import Controlador.AdaptadorUsuario;
import Modelo.Usuario;


public class BusquedaActivity extends AppCompatActivity {

    private RecyclerView listaUsuarios;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager lManager;
    List usuarios = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);



        listaUsuarios = (RecyclerView) findViewById(R.id.listaUsuarios);
        listaUsuarios.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        listaUsuarios.setLayoutManager(lManager);

        usuarios.add(new Usuario("Miguel", "Rodríguez", "Ruiz de los Paños", R.drawable.usuario));
        usuarios.add(new Usuario("Juan Luis", "Rodríguez","Ruiz de los Paños", R.drawable.usuario));
        usuarios.add(new Usuario("Ernesto", "Mediavilla", "", R.drawable.usuario));
        usuarios.add(new Usuario("Andrea", "Agudo", "", R.drawable.usuario));
        usuarios.add(new Usuario("Isabel", "Yeves", "", R.drawable.usuario));
        usuarios.add(new Usuario("Adrían","Álvarez", "Fernández", R.drawable.usuario));


        adaptador = new AdaptadorUsuario(usuarios);
        listaUsuarios.setAdapter(adaptador);

    }


}


