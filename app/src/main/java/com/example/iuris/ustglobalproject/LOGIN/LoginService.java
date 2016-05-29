package com.example.iuris.ustglobalproject.login;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by andreagudo3 on 26/05/2016.
 */
public interface LoginService {
    @POST("restservices/rest/services/login")
    Call<TokenResponse> getTokenAccess(@Body User user);
}
