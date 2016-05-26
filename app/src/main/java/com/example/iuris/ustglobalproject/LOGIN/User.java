package com.example.iuris.ustglobalproject.LOGIN;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andreagudo3 on 26/05/2016.
 */
public class User {
    @SerializedName("login")
    String login;
    @SerializedName("password")
    String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String usuario, String contra ) {
        this.login = usuario;
        this.password = contra;
    }
}
