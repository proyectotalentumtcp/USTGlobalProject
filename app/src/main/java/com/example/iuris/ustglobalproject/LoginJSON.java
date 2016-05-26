package com.example.iuris.ustglobalproject;

/**
 * Created by andreagudo3 on 25/05/2016.
 */
public class LoginJSON {

        @SerializedName("login")
        @Expose
        private String login;
        @SerializedName("password")
        @Expose
        private String password;

        /**
         * @return The login
         */
        public String getLogin() {
            return login;
        }

        /**
         * @param login The login
         */
        public void setLogin(String login) {
            this.login = login;
        }

        /**
         * @return The password
         */
        public String getPassword() {
            return password;
        }

        /**
         * @param password The password
         */
        public void setPassword(String password) {
            this.password = password;
        }
}