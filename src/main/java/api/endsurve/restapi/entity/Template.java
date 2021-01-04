package api.endsurve.restapi.entity;

import api.endsurve.restapi.json.JSONArrayUtils;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class Template {
    private final String name;
    private final String backend;
    private URL url;
    private final String[] processPreParameters;
    private final String[] installablePlugins;

    public Template(JSONObject object) {
        name = object.optString("name");
        backend = object.optString("backend");

        try {
            String urlString = object.optString("url");
            if (urlString == null) url = null;
            else url = new URL(urlString);
        } catch (MalformedURLException exception) {
            url = null;
        }

        JSONArray array = object.optJSONArray("processPreParameters");
        processPreParameters = JSONArrayUtils.toStringArray(array);

        array = object.optJSONArray("installablePlugins");
        installablePlugins = JSONArrayUtils.toStringArray(array);
    }

    public String getName() {
        return name;
    }

    public String getBackend() {
        return backend;
    }

    @Nullable
    public final URL getUrl() {
        return url;
    }

    public String[] getProcessPreParameters() {
        return processPreParameters;
    }

    public String[] getInstallablePlugins() {
        return installablePlugins;
    }

}
