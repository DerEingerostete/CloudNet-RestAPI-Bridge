package api.endsurve.restapi.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Map;

/**
 * The dataCatcher saves some data
 *
 * The dataCatcher can use a file
 * to save those but doesn't have to
 */
public interface DataCatcher {

    @NotNull
    Map<String, Object> asMap();

    @Nullable
    File getFile();

}
