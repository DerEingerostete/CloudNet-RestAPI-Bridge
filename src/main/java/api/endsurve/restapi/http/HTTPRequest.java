package api.endsurve.restapi.http;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface HTTPRequest {

    @NotNull
    RequestMethod getMethod();

    @NotNull
    Map<String, String> getHeaders();

}
