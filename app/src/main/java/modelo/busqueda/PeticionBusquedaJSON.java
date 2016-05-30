
package modelo.busqueda;



/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PeticionBusquedaJSON {

    @SerializedName("busqueda")
    @Expose
    public String busqueda;
    @SerializedName("session_id")
    @Expose
    public String sessionId;

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public String getSessionId() {
        return sessionId;
    }
}
