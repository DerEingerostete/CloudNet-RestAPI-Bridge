package api.endsurve.restapi.entity.proxy;

import org.json.JSONObject;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class Tablist {
    private final boolean enabled;
    private final String header;
    private final String footer;

    public Tablist(JSONObject object) {
        enabled = object.optBoolean("enabled");
        header = object.optString("header");
        footer = object.optString("footer");
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

}
