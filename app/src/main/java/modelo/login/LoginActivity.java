package modelo.login;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

    // Referencias
    EditText mUser, mPass;
    private LogEasyApi service;

    @BindView(R.id.bLogin)
    Button bLogin;

    CheckBox mCbShowPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        ButterKnife.bind(this);

        // Creando la forma del login
        mUser = (EditText) findViewById(R.id.usuario);
        mPass = (EditText) findViewById(R.id.contra);
        mCbShowPwd = (CheckBox) findViewById(R.id.cbShowPwd);

        mCbShowPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    mPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    mPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { attemptLogin();}});

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.api_url))
                .addConverterFactory(GsonConverterFactory.create()).build();

        service = retrofit.create(LogEasyApi.class);
    }

    /**
     * Intento de login con la forma especificada
     * Si existe algún error o campo vacío, se muestran
     * los errores y no se realiza el login
     */

    @OnClick(R.id.bLogin)
    public void attemptLogin() {

        // Reiniciando errores
        mUser.setError(null);
        mPass.setError(null);

        // Almacenar los valores en el momento del intento de conexión
        String login = mUser.getText().toString();
        String password = mPass.getText().toString();
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);

        if (login.equals("") || password.equals("")) {
            ;
        }else {


            progressDialog.setMessage("Comprobando...");
            progressDialog.show();
            progressDialog.setCancelable(false);
        }

        boolean cancel = false;
        View focusView = null;

        //Comprobación de que los campos están rellenos
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

            // Si existe algún error, no intentar el login
            focusView.requestFocus();
        }else {

            // Realización del envío de datos al servidor y recogida de la respuesta en forma JSON
            TokenRequest tokenRequest = new TokenRequest();

            tokenRequest.setlogin(login);
            tokenRequest.setPassword(password);

            Call<TokenResponse> tokenResponseCall = service.getTokenAccess(tokenRequest);
            tokenResponseCall.enqueue(new Callback<TokenResponse>() {
                @Override
                public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                    progressDialog.dismiss();
                    int statusCode = response.code();

                    TokenResponse tokenResponse = response.body();

                    Log.d("LoginActivity","onResponse: " + statusCode);
                    Session.getInstance().setSessionId(tokenResponse.getSession_id());
                    Session.getInstance().setImagenBase64(tokenResponse.getImageBase64());
                    Log.d("LoginActivity","Imagen Usuario: " + tokenResponse.getImageBase64());

                    if ( tokenResponse.getError_code().equals("0")) {
                        ;
                    }else{
                        Toast.makeText(getApplicationContext(), tokenResponse.getError_description() ,Toast.LENGTH_SHORT).show();
                    }

                    if (tokenResponse.getError_code().equals("0")) {
                        Intent ventanaSearch = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(ventanaSearch);
                    }
                }

                @Override
                public void onFailure(Call<TokenResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Error de conexión con el servidor",Toast.LENGTH_SHORT).show();
                    Log.d("LoginActivity", "onFailure: " + t.getMessage());
                }
            });
        }
    }
}

