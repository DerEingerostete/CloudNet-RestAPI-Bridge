package api.endsurve.restapi.http.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class StandardHTTPResponse implements HTTPResponse {
    private final String message;
    private final int code;

    public StandardHTTPResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public @NotNull int getCode() {
        return code;
    }

    @Override
    public @Nullable String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }

}
