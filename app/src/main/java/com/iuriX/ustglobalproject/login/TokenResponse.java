package com.iuriX.ustglobalproject.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andreagudo3 on 26/05/2016.
 */
public class TokenResponse {
    @SerializedName("session_id")
    @Expose
    private String session_id;

    @SerializedName("error_description")
    @Expose
    private String error_description;

    @SerializedName("error_code")
    private String error_code;

    public String getSession_id() {
        return session_id;
    }

    public String getError_description() {
        return error_description;
    }

    public String getError_code() {
        return error_code;
    }
}
