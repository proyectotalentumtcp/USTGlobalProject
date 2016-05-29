package Modelo.Detalles;

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

    public PeticionDetallesJSON (Integer idEmpleado, String sessionId){

        this.idEmpleado = idEmpleado;
        this.sessionId = sessionId;


    }

}
