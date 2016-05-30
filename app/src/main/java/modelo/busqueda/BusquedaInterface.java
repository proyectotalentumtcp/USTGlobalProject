<<<<<<< HEAD:app/src/main/java/Modelo/Busqueda/BusquedaInterface.java
=======
package modelo.busqueda;

>>>>>>> b58f7991faacda96cbb07f96fd41ffa5eccce55d:app/src/main/java/modelo/busqueda/BusquedaInterface.java

package modelo.busqueda;

import modelo.busqueda.PeticionBusquedaJSON;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
public interface BusquedaInterface {

    @POST("restservices/rest/services/get_ust_workers")
    Call<ListaEmpleados> getListaEmpleados(@Body PeticionBusquedaJSON peticionBusquedaJSON);
}
