package com.example.iuris.ustglobalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.iuris.ustglobalproject.R;

import Modelo.Usuario;

public class DetalleActivity extends AppCompatActivity {


    TextView nombreDetalle;
    TextView apellido1Detalle;
    TextView apellido2Detalle;
    TextView telefonoDetalle;
    TextView correoDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        nombreDetalle = (TextView)findViewById(R.id.nombreDetalle);
        apellido1Detalle = (TextView)findViewById(R.id.apellido1Detalle);
        apellido2Detalle = (TextView)findViewById(R.id.apellido2Detalle);
        telefonoDetalle = (TextView)findViewById(R.id.telefonoDetalle);
        correoDetalle = (TextView)findViewById(R.id.correoDetalle);

        Usuario userDetalle = (Usuario)getIntent().getSerializableExtra("usuario");

        nombreDetalle.setText(userDetalle.getNombre());
        apellido1Detalle.setText(userDetalle.getApellido1());
        apellido2Detalle.setText(userDetalle.getApellido2());
        telefonoDetalle.setText(userDetalle.getTelefono());
        correoDetalle.setText(userDetalle.getCorreo());






    }
}
