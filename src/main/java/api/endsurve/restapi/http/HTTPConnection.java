package api.endsurve.restapi.http;

import api.endsurve.restapi.http.response.APIResponse;
import api.endsurve.restapi.http.response.HTTPResponse;
import api.endsurve.restapi.http.response.StandardHTTPResponse;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class HTTPConnection {
    private JSONObject object;
    private HTTPResponse response;
    private Map<String, Object> map;
    private APIResponse apiResponse;

    private final URL url;
    private final HTTPRequest request;

    public HTTPConnection(URL url, HTTPRequest request) {
        this.url = url;
        this.request = request;
    }

    public void load() throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(false);
        connection.setDoInput(true);
        connection.setUseCaches(false);

        String method = request.getMethod().toString();
        connection.setRequestMethod(method);

        Map<String, String> headers = request.getHeaders();
        headers.forEach(connection::addRequestProperty);

        connection.connect();

        int code = connection.getResponseCode();
        String message = connection.getResponseMessage();
        response = new StandardHTTPResponse(message, code);

        Charset charset = StandardCharsets.UTF_8;
        InputStream stream = connection.getInputStream();
        StringWriter writer = new StringWriter();
        IOUtils.copy(stream, writer, charset);
        String jsonString = writer.toString();
        object = new JSONObject(jsonString);
        map = object.toMap();
        apiResponse = new APIResponse(object, message, code);

        connection.disconnect();
    }

    @Nullable
    public Map<String, Object> asMap() {
        return map;
    }

    @Nullable
    public JSONObject asJsonObject() {
        return object;
    }

    public HTTPResponse getResponse() {
        return response;
    }

    public APIResponse getApiResponse() {
        return apiResponse;
    }

}
