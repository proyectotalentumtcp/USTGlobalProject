package modelo.login;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends Activity {

    EditText mEmail, mPass;
    int contador = 3;
    private LogEasyApi service;

    @BindView(R.id.bLogin)
    Button bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        ButterKnife.bind(this);

        mEmail = (EditText) findViewById(R.id.usuario);
        mPass = (EditText) findViewById(R.id.contra);

        mPass.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { attemptLogin();}});


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.api_url))
                .addConverterFactory(GsonConverterFactory.create()).build();

        service = retrofit.create(LogEasyApi.class);
    }

    @OnClick(R.id.bLogin)
    public void attemptLogin() {
        mEmail.setError(null);
        mPass.setError(null);

        String email = mEmail.getText().toString();
        String password = mPass.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (password.equals("")) {
            mPass.setError("Campo vacío");
            focusView = mPass;
            cancel = true;
        }

        if (email.equals("")) {
            mEmail.setError("Campo vacío");
            focusView = mEmail;
            cancel = true;
        }


        if (cancel) {
            focusView.requestFocus();
        }else {
            final TokenRequest tokenRequest = new TokenRequest();

            tokenRequest.setEmail(mEmail.getText().toString());
            tokenRequest.setPassword(mPass.getText().toString());

            Call<TokenResponse> tokenResponseCall = service.getTokenAccess(tokenRequest);
            tokenResponseCall.enqueue(new Callback<TokenResponse>() {
                @Override
                public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                    int statusCode = response.code();

                    TokenResponse tokenResponse = response.body();

                    Log.d("LoginActivity","onResponse: " + statusCode);


                    Toast.makeText(getApplicationContext(), tokenResponse.getSession_id() ,Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), tokenResponse.getError_description() ,Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), tokenResponse.getError_code() ,Toast.LENGTH_SHORT).show();

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

