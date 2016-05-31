package modelo.detalles;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by lehmer on 28/05/16.
 */
public interface DetallesInterface {

    @POST("restservices/rest/services/get_ust_worker_details")
    Call<DetallesEmpleado> getDetallesEmpleado(@Body PeticionDetallesJSON peticionDetallesJSON);

}
