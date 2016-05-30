package modelo.detalles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lehmer on 28/05/16.
 */
public class DetallesJSON implements Serializable {

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
    @SerializedName("extension")
    @Expose
    private String extension;
    @SerializedName("telefono_directo")
    @Expose
    private String telefonoDirecto;
    @SerializedName("telefono_movil")
    @Expose
    private String telefonoMovil;
    @SerializedName("centralita")
    @Expose
    private String centralita;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("localizacion")
    @Expose
    private String localizacion;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("empresa")
    @Expose
    private String empresa;
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

    public String getExtension() {
        return extension;
    }

    public String getTelefonoDirecto() {
        return telefonoDirecto;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public String getCentralita() {
        return centralita;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public String getArea() {
        return area;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getImageBase64() {
        return imageBase64;
    }
}
