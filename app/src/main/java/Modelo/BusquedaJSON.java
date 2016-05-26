package Modelo;

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusquedaJSON {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellidos")
    @Expose
    private String apellidos;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("correo_alternativo")
    @Expose
    private String correoAlternativo;
    @SerializedName("telefono_directo")
    @Expose
    private String telefonoDirecto;
    @SerializedName("telefono_movil")
    @Expose
    private String telefonoMovil;
    @SerializedName("imageBase64")
    @Expose
    private String imageBase64;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }


    /**
     * @return The nombre
     */
    public String getNombre() {
        return nombre;
    }


    /**
     * @return The apellidos
     */
    public String getApellidos() {
        return apellidos;
    }


    /**
     * @return The correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @return The correoAlternativo
     */
    public String getCorreoAlternativo() {
        return correoAlternativo;
    }


    /**
     * @return The telefonoDirecto
     */
    public String getTelefonoDirecto() {
        return telefonoDirecto;
    }


    /**
     * @return The telefonoMovil
     */
    public String getTelefonoMovil() {
        return telefonoMovil;
    }


    /**
     * @return The imageBase64
     */
    public String getImageBase64() {
        return imageBase64;
    }

}
