package Modelo;

import java.io.Serializable;

/**
 * Created by Miguel Rodríguez on 23/05/2016.
 * Edited by Ernesto Mediavilla on 23/05/2016
 */
public class Usuario implements Serializable {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String correo;
    private int imagen;

    // Constructor con parametros
    public Usuario(String nombre, String apellido1, String apellido2, String telefono, String correo, int imagen){

        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.correo = correo;
        this.imagen = imagen;

    }

    public Usuario(){};

    // Métodos Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    // Métodos Getter
    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public int getImagen() {
        return imagen;
    }
}