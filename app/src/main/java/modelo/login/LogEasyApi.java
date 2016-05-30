package modelo.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by andreagudo3 on 29/05/2016.
 */
public interface LogEasyApi {
    @POST ("restservices/rest/services/login")
    Call<TokenResponse> getTokenAccess(@Body TokenRequest tokenRequest);
}
