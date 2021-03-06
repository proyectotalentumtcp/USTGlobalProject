package modelo.detalles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lehmer on 28/05/16.
 */
public class PeticionDetallesJSON {

    @SerializedName("id_empleado")
    @Expose
    public int idEmpleado;
    @SerializedName("session_id")
    @Expose
    public String sessionId;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
