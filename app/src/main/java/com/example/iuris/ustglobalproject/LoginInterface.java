package com.example.iuris.ustglobalproject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by andreagudo3 on 26/05/2016.
 */
public interface LoginInterface {
    @POST("users/new")
    Call<LoginJSON> createUser(@Body LoginJSON user);
}
