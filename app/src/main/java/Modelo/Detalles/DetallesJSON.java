package Modelo.Detalles;

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
     * @return The extension
     */
    public String getExtension() {
        return extension;
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
     * @return The centralita
     */
    public String getCentralita() {
        return centralita;
    }


    /**
     * @return The direccion
     */
    public String getDireccion() {
        return direccion;
    }


    /**
     * @return The localizacion
     */
    public String getLocalizacion() {
        return localizacion;
    }


    /**
     * @return The area
     */
    public String getArea() {
        return area;
    }


    /**
     * @return The empresa
     */
    public String getEmpresa() {
        return empresa;
    }


    /**
     * @return The imageBase64
     */
    public String getImageBase64() {
        return imageBase64;
    }
}
