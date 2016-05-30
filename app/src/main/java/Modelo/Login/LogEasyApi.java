package Modelo.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by andreagudo3 on 29/05/2016.
 */
public interface LogEasyApi {
<<<<<<< HEAD:app/src/main/java/com/iuriX/ustglobalproject/login/LogEasyApi.java
    @POST ("restservices/rest/services/get_ust_workers")
=======

    String URL = "http://ec2-52-19-159-183.eu-west-1.compute.amazonaws.com:8088/restservices/rest/services/";

    @POST ("login")
>>>>>>> 9e97a04b3e115ae53e679b48f852d7046096cc1b:app/src/main/java/Modelo/Login/LogEasyApi.java
    Call<TokenResponse> getTokenAccess(@Body TokenRequest tokenRequest);
}
