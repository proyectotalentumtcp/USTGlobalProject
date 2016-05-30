package Modelo.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by andreagudo3 on 29/05/2016.
 */
public interface LogEasyApi {
    @POST ("restservices/rest/services/get_ust_workers")
    Call<TokenResponse> getTokenAccess(@Body TokenRequest tokenRequest);
}
