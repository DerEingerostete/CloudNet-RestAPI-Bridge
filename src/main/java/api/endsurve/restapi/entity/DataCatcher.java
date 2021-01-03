package api.endsurve.restapi.entity;

import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * The dataCatcher saves some data
 *
 * The dataCatcher can use a file
 * to save those but doesn't have to
 */
public interface DataCatcher {

    @Nullable
    File getFile();

}
