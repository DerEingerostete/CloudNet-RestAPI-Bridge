package api.endsurve.restapi.auth;

import org.jetbrains.annotations.NotNull;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class StandardBridgeAuth implements BridgeAuth {
    private final String user;
    private final String token;

    public StandardBridgeAuth(String user, String token) {
        this.user = user;
        this.token = token;
    }

    @Override
    public @NotNull String getUser() {
        return user;
    }

    @Override
    public @NotNull String getToken() {
        return token;
    }

}
