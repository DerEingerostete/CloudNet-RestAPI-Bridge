package api.endsurve.restapi;

import api.endsurve.restapi.auth.StandardBridgeAuth;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class RestAPIBridge {
    private static StandardBridgeAuth auth;

    public static void login(String user, String token) {
        auth = new StandardBridgeAuth(user, token);
    }

    public static void logout() {
        auth = null;
    }

    public static int getModulesWebPort() {
        //TODO: WebPort
        return 0;
    }

}
