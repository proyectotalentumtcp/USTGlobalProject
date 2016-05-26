package com.example.iuris.ustglobalproject.LOGIN;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by andreagudo3 on 26/05/2016.
 */
public interface LoginService {
    @POST("/users/new")
    Call<User> createUser(@Body User user);
}
