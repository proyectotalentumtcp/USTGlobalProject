package Modelo.Detalles;

import Modelo.Detalles.PeticionDetallesJSON;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by lehmer on 28/05/16.
 */
public interface DetallesInterface {

    String URL = "http://ec2-52-19-159-183.eu-west-1.compute.amazonaws.com:8088/restservices/rest/services/";

    @POST("get_ust_workers_details")
    Call<PeticionDetallesJSON> postBusqueda(@Body PeticionDetallesJSON peticionDetallesJSON, Callback<DetallesEmpleado> detalles);

}
