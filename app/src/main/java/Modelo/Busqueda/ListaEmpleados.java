
package modelo.busqueda;


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

    public void setListaUsuarios(List<BusquedaJSON> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<BusquedaJSON> getListaUsuarios() {
        return listaUsuarios;
    }
}
