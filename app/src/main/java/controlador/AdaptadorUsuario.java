package controlador;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iuriX.ustglobalproject.DetalleActivity;
import modelo.Session;
import modelo.busqueda.ListaEmpleados;
import modelo.login.R;

/**
 * Created by Miguel Rodríguez on 23/05/2016.
 */
public class AdaptadorUsuario  extends RecyclerView.Adapter<AdaptadorUsuario.UsuarioViewHolder> {

    public ListaEmpleados usuarios;


    public static class UsuarioViewHolder extends RecyclerView.ViewHolder{

        public TextView nombre;
        public TextView apellidos;
        public ImageView imagen;

        public final View vista;

        public UsuarioViewHolder(View v){
            super(v);
            vista = v;
            nombre = (TextView)v.findViewById(R.id.nombre);
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


        byte[] decodedString = Base64.decode(imageString.getBytes(), Base64.URL_SAFE);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        viewHolder.imagen.setImageBitmap(decodedByte);

        viewHolder.vista.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Context contexto = v.getContext(); //com.iuriX.ustglobalproject.BusquedaActivity@7a87dca
                Session.getInstance().setId_empleado_seleccionado(usuarios.getListaUsuarios().get(position).getId());
                Log.d("ID EMPLEADO: ", String.valueOf(usuarios.getListaUsuarios().get(position).getId()));

                Intent intent = new Intent(contexto, DetalleActivity.class);

                contexto.startActivity(intent);
            }
        });
    }
}
