package api.endsurve.restapi.entity.proxy;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class DynamicFallback {
    private final String defaultFallback;
    private final FallbackGroup[] fallbacks;

    public DynamicFallback(JSONObject object) {
        defaultFallback = object.optString("defaultFallback");
        JSONArray array = object.optJSONArray("fallbacks");
        ArrayList<FallbackGroup> groups = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject fallback = array.optJSONObject(i);
            if (fallback == null) continue;
            groups.add(new FallbackGroup(fallback));
        }
        fallbacks = groups.toArray(new FallbackGroup[0]);
    }

    public String getDefaultFallback() {
        return defaultFallback;
    }

    public FallbackGroup[] getFallbacks() {
        return fallbacks;
    }

}
