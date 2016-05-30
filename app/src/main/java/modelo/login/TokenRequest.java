package modelo.login;

/**
 * Created by andreagudo3 on 29/05/2016.
 */
public class TokenRequest {
    private String login;
    private String password;

    public String getlogin() {
        return login;
    }

    public void setlogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
