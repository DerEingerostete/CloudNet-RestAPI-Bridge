package api.endsurve.restapi.http;

import api.endsurve.restapi.auth.BridgeAuth;
import api.endsurve.restapi.validation.Validate;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class HTTPRequestBuilder {
    private final HashMap<String, String> headers;
    private final RequestMethod method;

    public HTTPRequestBuilder(RequestMethod method) {
        this.headers = new HashMap<>();
        this.method = method;
    }

    public void withAuth(BridgeAuth auth) {
        Validate.notNull(auth, "Auth cannot be null");
        headers.put("-Xcloudnet-user", auth.getUser());
        headers.put("-Xcloudnet-token", auth.getToken());
    }

    public void withHeader(String key, String value) {
        Validate.notNull(key, "Key cannot be null");
        headers.put(key, value);
    }

    public HTTPRequest build() {
        return new HTTPRequest() {

            @Override
            public @NotNull RequestMethod getMethod() {
                return method;
            }

            @Override
            public @NotNull Map<String, String> getHeaders() {
                return headers;
            }

        };
    }

}
