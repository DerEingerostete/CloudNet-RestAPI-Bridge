package api.endsurve.restapi.http.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface HTTPResponse {

    @NotNull
    int getCode();

    @Nullable
    String getMessage();

    @NotNull
    String toString();

}
