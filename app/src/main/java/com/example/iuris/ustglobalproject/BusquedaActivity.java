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

        usuarios.add(new Usuario("Miguel", "Rodríguez", "Ruiz de los Paños", "", "676664804", "miguel.rodriguezruiz1@gmail.com", "NULL", "dir", "3", "001", "A3", "", "Telefónica", R.drawable.usuario));
        usuarios.add(new Usuario("Juan Luis", "Rodríguez","Ruiz de los Paños", "", "", "", "", "", "", "", "", "", "Talentum Empleo", R.drawable.usuario));
        usuarios.add(new Usuario("Ernesto", "Mediavilla", "del Río", "914150650", "649023872", "lehmer5@gmail.com", "lehmer5@hotmail.com", "Santa Hortensia, 47", "14", "003", "A2", "", "UST Global", R.drawable.usuario));
        usuarios.add(new Usuario("Andrea", "Agudo", "Martínez", "", "658968812", "andreaagudo3@gmail.com", "vacio", "", "", "004", "B1", "", "TCP", R.drawable.usuario));
        usuarios.add(new Usuario("Isabel", "Yeves", "Sánchez", "", "636515445", "isabelyeves@hotmail.com", "isabelyeves@gmail.com", "Isla de Arosa", "3", "005", "C2", "", "Talentum", R.drawable.usuario));
        usuarios.add(new Usuario("Pablo", "Moyano", "Alcántara", "", "676101967", "pablomoyanoalcantara89@gmail.com", "", "EMPTY", "UNKNOWN", "006", "A4", "", "Desconocido", R.drawable.usuario));
        usuarios.add(new Usuario("Adrían","Álvarez", "Fernández", "", "684610056", "adrix1990@hotmail.com", "", "Dirección desconocida", "15", "010", "C4", "", "No aplica", R.drawable.usuario));

        adaptador = new AdaptadorUsuario(usuarios);
        listaUsuarios.setAdapter(adaptador);

    }


}


