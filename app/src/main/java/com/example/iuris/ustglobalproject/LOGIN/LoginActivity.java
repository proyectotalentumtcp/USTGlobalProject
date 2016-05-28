package com.example.iuris.ustglobalproject.LOGIN;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iuris.ustglobalproject.MainActivity;
import com.example.iuris.ustglobalproject.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by andreagudo3 on 24/05/2016.
 */
public class LoginActivity extends Activity {
    Button bLogin;
    EditText ed1, ed2;
    int contador = 3;

   /* public static final String BASE_URL = "http://api.myservice.com/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        bLogin = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.usuario);
        ed2 = (EditText) findViewById(R.id.contra);



        /*User apiService =
                retrofit.create(User.class);
        Call<User> call = apiService.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getApplicationContext(), "Cargando...", Toast.LENGTH_SHORT).show();
                Intent ventanaSearch = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(ventanaSearch);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                contador--;

                if (contador != 0) {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getApplicationContext(), "Demasiados intentos, login deshabilitado", Toast.LENGTH_SHORT).show();
                    bLogin.setEnabled(false);
                }
            }

        });
    }*/
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ed1.getText().toString().equals("admin") && ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Cargando...", Toast.LENGTH_SHORT).show();
                    Intent ventanaSearch = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(ventanaSearch);

                } else {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();

                    contador--;

                    if (contador == 0) {
                        Toast.makeText(getApplicationContext(), "Demasiados intentos, login deshabilitado", Toast.LENGTH_SHORT).show();
                        bLogin.setEnabled(false);
                    }
                }
            }
        });
    }
}


