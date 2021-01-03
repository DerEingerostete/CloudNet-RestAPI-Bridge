package api.endsurve.restapi.http;

import api.endsurve.restapi.auth.BridgeAuth;
import api.endsurve.restapi.http.response.APIResponse;
import api.endsurve.restapi.validation.Validate;

import java.net.URL;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class TemplateHTTPRequests {

    public static APIResponse utilAPI(BridgeAuth auth) throws Exception {
        Validate.notNull(auth, "No authentication is given");
        URL url = new URL("http://193.23.126.71:1420/cloudnet/api/v1/util");
        RequestMethod method = RequestMethod.GET;
        HTTPRequestBuilder builder = new HTTPRequestBuilder(method);
        builder.withAuth(auth);
        builder.withHeader("-Xmessage", "cloudnetwork");
        HTTPRequest request = builder.build();
        HTTPConnection connection = new HTTPConnection(url, request);
        return connection.getApiResponse();
    }

}
