package modelo.busqueda;

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
import android.os.Parcel;
import android.os.Parcelable;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCorreoAlternativo(String correoAlternativo) {
        this.correoAlternativo = correoAlternativo;
    }

    public void setTelefonoDirecto(String telefonoDirecto) {
        this.telefonoDirecto = telefonoDirecto;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

}