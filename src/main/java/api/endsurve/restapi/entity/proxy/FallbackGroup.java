package api.endsurve.restapi.entity.proxy;

import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class FallbackGroup {
    private final String group;
    private final String permission;

    public FallbackGroup(JSONObject object) {
        group = object.optString("group");
        permission = object.optString("permission");
    }

    public String getGroup() {
        return group;
    }

    @Nullable
    public String getPermission() {
        return permission;
    }

}
