package modelo;

import java.util.List;

import modelo.busqueda.BusquedaJSON;
import modelo.busqueda.ListaEmpleados;

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
public class Session {

    private static Session sharedInstance = null;

    public static Session getInstance(){

        if (sharedInstance == null){

            sharedInstance = new Session();

        }

        return sharedInstance;

    }

    public String sessionId;

    public int id_empleado_seleccionado;

    public ListaEmpleados listaEmpleadosSession;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId){

        this.sessionId = sessionId;

    }

    public int getId_empleado_seleccionado() {
        return id_empleado_seleccionado;
    }

    public void setId_empleado_seleccionado(int id_empleado_seleccionado) {
        this.id_empleado_seleccionado = id_empleado_seleccionado;
    }

    public ListaEmpleados getListaEmpleadosSession() {
        return listaEmpleadosSession;
    }

    public void setListaEmpleadosSession(ListaEmpleados listaEmpleadosSession) {
        this.listaEmpleadosSession = listaEmpleadosSession;
    }
}
