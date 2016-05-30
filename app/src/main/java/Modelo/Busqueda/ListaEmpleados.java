<<<<<<< HEAD
package modelo.Busqueda;
=======
package Modelo.busqueda;
>>>>>>> 1956714dc4a55cc59aba8b359a40bffae3717710

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
public class ListaEmpleados implements Serializable {

    @SerializedName("listaUsuarios")
    @Expose
    public List<BusquedaJSON> listaUsuarios;


}
