package Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Miguel Rodríguez on 23/05/2016.
 * Edited by Ernesto Mediavilla on 23/05/2016
 */
public class Usuario implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
//    @SerializedName("apellido1")
//    @Expose
//    private String apellido1;
//    @SerializedName("apellido2")
//    @Expose
//    private String apellido2;
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
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("extension")
    @Expose
    private String extension;
    @SerializedName("centralita")
    @Expose
    private String centralita;
    @SerializedName("localizacion")
    @Expose
    private String localizacion;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("empresa")
    @Expose
    private String empresa;
    @SerializedName("imagen")
    @Expose
    private int imagen;
    @SerializedName("imageBase64")
    @Expose
    private String imageBase64;

    // Constructor con parametros
    //public Usuario(String nombre, String apellido1, String apellido2, String telefonoDirecto, String telefonoMovil, String correo, String correoAlternativo, String direccion, String extension, String centralita, String localizacion, String area, String empresa, int imagen){
    public Usuario(Integer id, String nombre, String apellidos, String telefonoDirecto, String telefonoMovil, String correo, String correoAlternativo, String direccion, String extension, String centralita, String localizacion, String area, String empresa, int imagen){

        this.id = id;
        this.nombre = nombre;
        //this.apellido1 = apellido1;
        //this.apellido2 = apellido2;
        this.apellidos = apellidos;
        this.telefonoDirecto = telefonoDirecto;
        this.telefonoMovil = telefonoMovil;
        this.correo = correo;
        this.correoAlternativo = correoAlternativo;
        this.direccion = direccion;
        this.extension = extension;
        this.centralita = centralita;
        this.localizacion = localizacion;
        this.area = area;
        this.empresa = empresa;
        this.imagen = imagen;

    }

    public Usuario() {};

    // Métodos Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public void setApellido1(String apellido) {
//        this.apellido1 = apellido;
//    }

//    public void setApellido2(String apellido) {
//        this.apellido2 = apellido;
//    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefonoDirecto(String telefono) {
        this.telefonoDirecto = telefono;
    }

    public void setTelefonoMovil(String telefono) {
        this.telefonoMovil = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCorreoAlternativo(String correo) {
        this.correoAlternativo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setExtension(String Extension) {
        this.extension = Extension;
    }

    public void setCentralita(String Centralita) {
        this.centralita = Centralita;
    }

    public void setLocalizacion(String Localizacion) {
        this.localizacion = Localizacion;
    }

    public void setArea(String Area) {
        this.area = Area;
    }

    public void setEmpresa(String Empresa) {
        this.empresa = Empresa;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    // Métodos Getter
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

//    public String getApellido1() {
//        return apellido1;
//    }

//    public String getApellido2() {
//        return apellido2;
//    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefonoDirecto() {
        return telefonoDirecto;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCorreoAlternativo() {
        return correoAlternativo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getExtension() {
        return extension;
    }

    public String getCentralita() {
        return centralita;
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

    public int getImagen() {
        return imagen;
    }
}
