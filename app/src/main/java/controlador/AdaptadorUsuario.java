package controlador;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.iuriX.ustglobalproject.DetalleActivity;


import java.util.List;

import modelo.Session;
import modelo.busqueda.BusquedaInterface;
import modelo.busqueda.BusquedaJSON;

import modelo.busqueda.ListaEmpleados;
import modelo.busqueda.PeticionBusquedaJSON;
import modelo.detalles.PeticionDetallesJSON;
import modelo.login.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Miguel Rodríguez on 23/05/2016.
 */
public class AdaptadorUsuario  extends RecyclerView.Adapter<AdaptadorUsuario.UsuarioViewHolder> {

    public ListaEmpleados usuarios;


    public static class UsuarioViewHolder extends RecyclerView.ViewHolder{

        public TextView nombre;
//        public TextView apellido1;
//        public TextView apellido2;
        public TextView apellidos;
        public ImageView imagen;

        public final View vista;


        public UsuarioViewHolder(View v){
            super(v);
            vista = v;
            nombre = (TextView)v.findViewById(R.id.nombre);
//            apellido1 = (TextView)v.findViewById(R.id.apellido1);
//            apellido2 = (TextView)v.findViewById(R.id.apellido2);
            apellidos = (TextView)v.findViewById(R.id.apellidos);
            imagen = (ImageView)v.findViewById(R.id.imagen);

        }

    }



    public AdaptadorUsuario(ListaEmpleados usuarios){

        this.usuarios = usuarios;

    }

    @Override
    public int getItemCount() {
        return usuarios.getListaUsuarios().size();
    }


    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        viewGroup.setClickable(true);
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);

        return new UsuarioViewHolder(v);
    }



    @Override
    public void onBindViewHolder(UsuarioViewHolder viewHolder, final int position) {

        viewHolder.nombre.setText(usuarios.getListaUsuarios().get(position).getNombre());
        viewHolder.apellidos.setText(usuarios.getListaUsuarios().get(position).getApellidos());

        String imageString = usuarios.getListaUsuarios().get(position).getImageBase64();
        Log.i("imagen" + String.valueOf(position), imageString); //ok

        imageString = imageString.substring(imageString.indexOf(",") + 1);
        byte[] decodedString = Base64.decode(imageString.getBytes(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);



        //OK
        //Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length); //decoder->decode returned false

         //viewHolder.imagen.setImageBitmap(decodedByte);

        viewHolder.vista.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                Context contexto = v.getContext(); //com.iuriX.ustglobalproject.BusquedaActivity@7a87dca
                ViewGroup.LayoutParams parametros = v.getLayoutParams();
                Session.getInstance().setId_empleado_seleccionado(usuarios.getListaUsuarios().get(position).getId());
                Log.d("ID EMPLEADO", String.valueOf(usuarios.getListaUsuarios().get(position).getId()));

                Log.i("parametros",String.valueOf(parametros));
                Intent intent = new Intent(contexto, DetalleActivity.class);

                Toast.makeText(contexto, "Esto Pasa a la siguiente activity", Toast.LENGTH_LONG).show();

                // Aqui va la llamada al servicio Rest que completa la vista del detalle
                // tienes que pasar en un intent los datos a la siguiente vista

                contexto.startActivity(intent);

                /*usuario user = new Usuario();

                user.setNombre(usuarios.get(position).getNombre());
                user.setApellidos(usuarios.get(position).getApellidos());
                user.setImagen(usuarios.get(position).getId());
                user.setTelefonoDirecto(usuarios.get(position).getTelefonoDirecto());
                user.setTelefonoMovil(usuarios.get(position).getTelefonoMovil());
                user.setCorreo(usuarios.get(position).getCorreo());
                user.setCorreoAlternativo(usuarios.get(position).getCorreoAlternativo());
                user.setDireccion(usuarios.get(position).getDireccion());
                user.setExtension(usuarios.get(position).getExtension());
                user.setCentralita(usuarios.get(position).getCentralita());
                user.setLocalizacion(usuarios.get(position).getLocalizacion());
                user.setArea(usuarios.get(position).getArea());
                user.setEmpresa(usuarios.get(position).getEmpresa());*/

            }
        });

    }

}
