package modelo.login;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.iuriX.ustglobalproject.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import modelo.Session;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends Activity {

    EditText mUser, mPass;
    private LogEasyApi service;

    @BindView(R.id.bLogin)
    Button bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        ButterKnife.bind(this);

        mUser = (EditText) findViewById(R.id.usuario);
        mPass = (EditText) findViewById(R.id.contra);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { attemptLogin();}});

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.api_url))
                .addConverterFactory(GsonConverterFactory.create()).build();

        service = retrofit.create(LogEasyApi.class);
    }

    @OnClick(R.id.bLogin)
    public void attemptLogin() {
        mUser.setError(null);
        mPass.setError(null);

        String login = mUser.getText().toString();
        String password = mPass.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (password.equals("")) {
            mPass.setError("Campo vacío");
            focusView = mPass;
            cancel = true;
        }

        if (login.equals("")) {
            mUser.setError("Campo vacío");
            focusView = mUser;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        }else {
            final TokenRequest tokenRequest = new TokenRequest();

            tokenRequest.setlogin(login);
            tokenRequest.setPassword(password);

            for (int x=0; x < login.length(); x++) {
                if (login.charAt(x) != ' ')
                    NoWhite += login.charAt(x);
            }

            Call<TokenResponse> tokenResponseCall = service.getTokenAccess(tokenRequest);
            tokenResponseCall.enqueue(new Callback<TokenResponse>() {
                @Override
                public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                    int statusCode = response.code();

                    TokenResponse tokenResponse = response.body();

                    Log.d("LoginActivity","onResponse: " + statusCode);
                    Session.getInstance().setSessionId(tokenResponse.getSession_id());

                    Toast.makeText(getApplicationContext(), tokenResponse.getError_description() ,Toast.LENGTH_SHORT).show();

                    if (tokenResponse.getError_code().equals("0")) {
                        Intent ventanaSearch = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(ventanaSearch);
                    }
                }

                @Override
                public void onFailure(Call<TokenResponse> call, Throwable t) {
                    Log.d("LoginActivity", "onFailure: " + t.getMessage());
                }
            });

        }
    }
}

