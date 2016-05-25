package com.example.iuris.ustglobalproject;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by andreagudo3 on 25/05/2016.
 */
public class LoginJSON {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toJSON() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("login", getLogin());
            jsonObject.put("password", getPassword());
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
