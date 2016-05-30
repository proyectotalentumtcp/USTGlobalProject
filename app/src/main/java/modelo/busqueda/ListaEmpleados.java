
package modelo.busqueda;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
public class ListaEmpleados implements Serializable {

    @SerializedName("empleados")
    @Expose
    public List<BusquedaJSON> empleados;

    public void setListaUsuarios(List<BusquedaJSON> listaUsuarios) {
        this.empleados = listaUsuarios;
    }

    public List<BusquedaJSON> getListaUsuarios() {

        return empleados;
    }
}
