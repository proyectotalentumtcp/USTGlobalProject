package modelo.login;

/**
 * Created by andreagudo3 on 29/05/2016.
 */
public class TokenRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
