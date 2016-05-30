package modelo.busqueda;
<<<<<<< HEAD:app/src/main/java/Modelo/Busqueda/BusquedaJSON.java
=======

>>>>>>> b58f7991faacda96cbb07f96fd41ffa5eccce55d:app/src/main/java/modelo/busqueda/BusquedaJSON.java

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BusquedaJSON implements Serializable{

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

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCorreoAlternativo() {
        return correoAlternativo;
    }

    public String getTelefonoDirecto() {
        return telefonoDirecto;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public String getImageBase64() {
        return imageBase64;
    }
}
