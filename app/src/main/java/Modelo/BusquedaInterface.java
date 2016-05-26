package Modelo;

import Modelo.PeticionBusquedaJSON;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
public interface BusquedaInterface {

    @POST("get_ust_workers")
    Call<PeticionBusquedaJSON> postBusqueda(@Body PeticionBusquedaJSON peticionBusquedaJSON, Callback<ListaEmpleados> empleados);
}
