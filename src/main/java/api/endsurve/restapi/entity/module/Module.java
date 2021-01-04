package api.endsurve.restapi.entity.module;

import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class Module {
    private final String name;
    private final PermissionPool permissionPool;

    public Module(JSONObject object) {
        name = object.optString("name");

        JSONObject catcherObject = object.optJSONObject("dataCatcher");
        JSONObject poolObject = catcherObject.optJSONObject("permissionPool");
        permissionPool = new PermissionPool(poolObject, catcherObject);
    }

    @Nullable
    public String getName() {
        return name;
    }

    public PermissionPool getPermissionPool() {
        return permissionPool;
    }

}
