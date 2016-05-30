package modelo.login;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iuriX.ustglobalproject.BusquedaActivity;

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
    // int contador = 3;
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
                        Intent ventanaSearch = new Intent(getApplicationContext(), BusquedaActivity.class);
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
    /*blogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(ed1.getText().toString().equals("admin") && ed2.getText().toString().equals("admin")) {
                Toast.makeText(getApplicationContext(), "Cargando...",Toast.LENGTH_SHORT).show();
                Intent ventanaSearch = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(ventanaSearch);

            }
            else{
                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show();

                contador--;


                if (contador == 0) {
                    Toast.makeText(getApplicationContext(), "Demasiados intentos, login deshabilitado",Toast.LENGTH_SHORT).show();
                    blogin.setEnabled(false);
                }
            }
        }
    });*/

