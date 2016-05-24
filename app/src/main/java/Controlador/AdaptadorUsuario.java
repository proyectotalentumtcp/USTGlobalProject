package Controlador;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iuris.ustglobalproject.DetalleActivity;
import com.example.iuris.ustglobalproject.R;

import java.util.List;

import Modelo.Usuario;

/**
 * Created by Miguel Rodríguez on 23/05/2016.
 */
public class AdaptadorUsuario  extends RecyclerView.Adapter<AdaptadorUsuario.UsuarioViewHolder>{

    private List<Usuario> usuarios;



    public static class UsuarioViewHolder extends RecyclerView.ViewHolder{

        public TextView nombre;
        public TextView apellido1;
        public TextView apellido2;
        public TextView telefono;
        public TextView correo;
        public ImageView imagen;

        public final View vista;

        public UsuarioViewHolder(View v){
            super(v);
            vista = v;
            nombre = (TextView)v.findViewById(R.id.nombre);
            apellido1 = (TextView)v.findViewById(R.id.apellido1);
            apellido2 = (TextView)v.findViewById(R.id.apellido2);
            telefono = (TextView)v.findViewById(R.id.telefono);
            correo = (TextView)v.findViewById(R.id.correo);
            imagen = (ImageView)v.findViewById(R.id.imagen);

        }

    }



    public AdaptadorUsuario(List<Usuario> usuarios){

        this.usuarios = usuarios;

    }


    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        viewGroup.setClickable(true);
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);

        return new UsuarioViewHolder(v);
    }



    @Override
    public void onBindViewHolder(UsuarioViewHolder viewHolder, final int position) {

        viewHolder.imagen.setImageResource(usuarios.get(position).getImagen());
        viewHolder.nombre.setText(usuarios.get(position).getNombre());
        viewHolder.apellido1.setText(usuarios.get(position).getApellido1());
        viewHolder.apellido2.setText(usuarios.get(position).getApellido2());

        viewHolder.vista.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                Context contexto = v.getContext();
                Intent intent = new Intent(contexto, DetalleActivity.class);
                Usuario user = new Usuario();

                user.setNombre(usuarios.get(position).getNombre());
                user.setApellido1(usuarios.get(position).getApellido1());
                user.setApellido2(usuarios.get(position).getApellido2());
                user.setImagen(usuarios.get(position).getImagen());

                intent.putExtra("usuario", user);

                contexto.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}