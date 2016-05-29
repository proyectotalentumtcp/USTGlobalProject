<<<<<<< HEAD:app/src/main/java/com/example/iuris/ustglobalproject/LOGIN/LoginService.java
package com.example.iuris.ustglobalproject.login;
=======
package com.iuriX.ustglobalproject.LOGIN;

>>>>>>> 917a1edfb3c51bb6347f0a714157d8255a48428b:app/src/main/java/com/iuriX/ustglobalproject/LOGIN/LoginService.java
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by andreagudo3 on 26/05/2016.
 */
public interface LoginService {
<<<<<<< HEAD:app/src/main/java/com/example/iuris/ustglobalproject/LOGIN/LoginService.java
    @POST("restservices/rest/services/login")
    Call<TokenResponse> getTokenAccess(@Body User user);
=======

    String URL = "http://ec2-52-19-159-183.eu-west-1.compute.amazonaws.com:8088/restservices/rest/services/";

    @POST("/users/new")
    Call<User> createUser(@Body User user);
>>>>>>> 917a1edfb3c51bb6347f0a714157d8255a48428b:app/src/main/java/com/iuriX/ustglobalproject/LOGIN/LoginService.java
}
