package Modelo.Busqueda;

import Modelo.ListaEmpleados;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
public interface BusquedaInterface {

    String URL = "http://ec2-52-19-159-183.eu-west-1.compute.amazonaws.com:8088/restservices/rest/services/";

    @POST("get_ust_workers")
    Call<PeticionBusquedaJSON> postBusqueda(@Body PeticionBusquedaJSON peticionBusquedaJSON, Callback<ListaEmpleados> empleados);
}
