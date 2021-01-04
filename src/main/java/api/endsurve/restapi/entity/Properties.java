package api.endsurve.restapi.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class Properties {
    private final String name;
    private final DataCatcher dataCatcher;
    private final File file;
    private final File catcherFile;

    public Properties(JSONObject object) {
        name = object.optString("name");

        String fileString = object.optString("file");
        if (fileString == null) file = null;
        else file = new File(fileString);

        JSONObject catcherObject = object.optJSONObject("dataCatcher");
        String catcherFileString = catcherObject.optString("file");
        if (catcherFileString != null)
            catcherFile = new File(catcherFileString);
        else catcherFile = null;
        Map<String, Object> allValues = new HashMap<>(catcherObject.toMap());

        dataCatcher = new DataCatcher() {
            @Override
            public @NotNull Map<String, Object> asMap() {
                return allValues;
            }

            @Override
            public @Nullable File getFile() {
                return catcherFile;
            }
        };
    }

    public String getName() {
        return name;
    }

    public DataCatcher getDataCatcher() {
        return dataCatcher;
    }

    public File getFile() {
        return file;
    }

}
