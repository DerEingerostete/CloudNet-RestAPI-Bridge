package api.endsurve.restapi.auth;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class StandardBridgeAuth {
    private final String user;
    private final String token;

    public StandardBridgeAuth(String user, String token) {
        this.user = user;
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }
}
