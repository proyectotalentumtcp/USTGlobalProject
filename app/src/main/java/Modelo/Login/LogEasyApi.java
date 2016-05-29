package Modelo.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by andreagudo3 on 29/05/2016.
 */
public interface LogEasyApi {

    String URL = "http://ec2-52-19-159-183.eu-west-1.compute.amazonaws.com:8088/restservices/rest/services/";

    @POST ("login")
    Call<TokenResponse> getTokenAccess(@Body TokenRequest tokenRequest);
}
