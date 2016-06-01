package modelo.detalles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lehmer on 28/05/16.
 */
public class DetallesEmpleado implements Serializable {

    @SerializedName("detallesUsuario")
    @Expose
    public List<DetallesJSON> detallesUsuario;

    public void setDetallesUsuario(List<DetallesJSON> detallesUsuario) {
        this.detallesUsuario = detallesUsuario;
    }

    public List<DetallesJSON> getDetallesUsuario() {
        return detallesUsuario;
    }
}
