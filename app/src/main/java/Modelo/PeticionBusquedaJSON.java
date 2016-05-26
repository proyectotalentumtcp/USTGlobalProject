package Modelo;

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

    public PeticionBusquedaJSON (String busqueda, String sessionId){

        this.busqueda = busqueda;
        this.sessionId = sessionId;


    }

}
