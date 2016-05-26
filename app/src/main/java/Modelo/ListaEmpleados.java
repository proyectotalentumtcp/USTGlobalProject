package Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
public class ListaEmpleados {

    @SerializedName("listaUsuarios")
    @Expose
    public List<BusquedaJSON> listaUsuarios;


}
