package Modelo.Login;

/**
 * Created by andreagudo3 on 29/05/2016.
 */
public class TokenRequest {
    private String username;
    private String password;

    public String getEmail() {
        return username;
    }

    public void setEmail(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
