package api.endsurve.restapi.entity.server;

import api.endsurve.restapi.entity.Properties;
import org.json.JSONObject;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class ServerConfig {
    private final String extra;
    private final boolean hideServer;
    private final long startup;
    private final Properties properties;

    public ServerConfig(JSONObject object) {
        extra = object.optString("extra");
        hideServer = object.optBoolean("hideServer");
        startup = object.optLong("startup");

        JSONObject propertiesObject = object.optJSONObject("properties");
        properties = new Properties(propertiesObject);
    }

    public long getStartup() {
        return startup;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getExtra() {
        return extra;
    }

    public boolean isServerHidden() {
        return hideServer;
    }

}
