<<<<<<< HEAD
package modelo.Busqueda;
=======
package Modelo.busqueda;
>>>>>>> 1956714dc4a55cc59aba8b359a40bffae3717710

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
public interface BusquedaInterface {

    @POST("restservices/rest/services/get_ust_workers")
    Call<PeticionBusquedaJSON> getPeticionBusquedaJSON(@Body PeticionBusquedaJSON peticionBusquedaJSON, Callback<ListaEmpleados> empleados);
}
