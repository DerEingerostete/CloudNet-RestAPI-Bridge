package api.endsurve.restapi.http;

import api.endsurve.restapi.auth.BridgeAuth;
import api.endsurve.restapi.http.exception.AuthenticationException;
import api.endsurve.restapi.http.response.APIResponse;
import api.endsurve.restapi.http.response.HTTPResponse;
import api.endsurve.restapi.validation.Validate;

import java.io.IOException;
import java.net.URL;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class TemplateHTTPRequests {

    public static APIResponse utilAPI(BridgeAuth auth, String message, String value) throws Exception {
        Validate.notNull(auth, "No authentication is given");
        URL url = new URL(auth.getURL() + "/cloudnet/api/v1/util");
        RequestMethod method = RequestMethod.GET;
        HTTPRequestBuilder builder = new HTTPRequestBuilder(method);
        builder.withAuth(auth);
        builder.withHeader("-Xmessage", message);
        if (value != null)
            builder.withHeader("-Xvalue", value);
        HTTPRequest request = builder.build();
        HTTPConnection connection = new HTTPConnection(url, request);
        try {
            connection.load();
        } catch (IOException exception) {
            if (connection.getResponse() != null) {
                HTTPResponse response = connection.getResponse();
                if (response.getCode() == 401)
                    throw new AuthenticationException("Authentication failed, check your login", exception);
            }
            throw exception;
        }
        return connection.getApiResponse();
    }

    public static APIResponse serverInfosAPI(BridgeAuth auth) throws Exception {
        return utilAPI(auth, "serverInfos", null);
    }

    public static APIResponse cloudNetworkAPI(BridgeAuth auth) throws Exception {
        return utilAPI(auth, "cloudnetwork", null);
    }

    public static APIResponse startServerAPI(BridgeAuth auth, String name) throws Exception {
        return utilAPI(auth, "startserver", name);
    }

    public static APIResponse startProxyAPI(BridgeAuth auth, String name) throws Exception {
        return utilAPI(auth, "startproxy", name);
    }

}
