package modelo;

/**
 * Created by Miguel Rodríguez on 26/05/2016.
 */
public class Session {

    private static Session sharedInstance = null;

    public static Session getInstance(){

        if (sharedInstance == null){

            sharedInstance = new Session();

        }

        return sharedInstance;

    }

    public String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId){

        this.sessionId = sessionId;

    }
}
