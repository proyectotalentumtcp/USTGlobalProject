<<<<<<< HEAD:app/src/main/java/Modelo/Busqueda/ListaEmpleados.java

package modelo.busqueda;

=======
package modelo.busqueda;
>>>>>>> b58f7991faacda96cbb07f96fd41ffa5eccce55d:app/src/main/java/modelo/busqueda/ListaEmpleados.java

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
