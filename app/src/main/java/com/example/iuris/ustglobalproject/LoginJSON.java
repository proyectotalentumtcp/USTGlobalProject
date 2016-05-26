package com.example.iuris.ustglobalproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andreagudo3 on 25/05/2016.
 */
public class LoginJSON {

        @SerializedName("login")
        @Expose
         String login;
        @SerializedName("password")
        @Expose
         String password;


    public LoginJSON(String usuario, String contra ) {
        this.login = usuario;
        this.password = contra;
    }
}