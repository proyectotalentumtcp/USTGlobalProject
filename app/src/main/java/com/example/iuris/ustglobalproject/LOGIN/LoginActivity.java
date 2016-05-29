package com.example.iuris.ustglobalproject.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iuris.ustglobalproject.BusquedaActivity;
import com.example.iuris.ustglobalproject.MainActivity;
import com.example.iuris.ustglobalproject.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by andreagudo3 on 24/05/2016.
 */
public class LoginActivity extends Activity {
    Button blogin;
    EditText ed1, ed2;
    int contador = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        blogin = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.usuario);
        ed2 = (EditText) findViewById(R.id.contra);


     Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.api_url))
                .addConverterFactory(GsonConverterFactory.create()).build();

        LoginService service = retrofit.create(LoginService.class);
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
}


