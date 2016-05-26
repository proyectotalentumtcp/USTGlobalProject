package Modelo;

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


    public String id_session;

    public String getId_session() {
        return id_session;
    }


    public void setId_session(String id_session){

        this.id_session = id_session;

    }
}
