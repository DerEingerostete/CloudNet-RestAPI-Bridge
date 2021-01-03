package api.endsurve.restapi.entity.module;

import api.endsurve.restapi.entity.DataCatcher;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class PermissionPool implements DataCatcher {
    private final boolean available;
    private final Map<String, PermissionGroup> groups;
    private final PermissionGroup defaultGroup;
    private final boolean notifyService;
    private final File file;

    public PermissionPool(JSONObject object) {
        available = object.optBoolean("available");
        notifyService = object.optBoolean("notifyService");

        String fileString = object.optString("file");
        if (fileString == null) file = null;
        else file = new File(fileString);

        groups = new HashMap<>();
        JSONObject groupsObject = object.optJSONObject("groups");

        JSONObject defaultGroupObject = groupsObject.optJSONObject("default");
        if (defaultGroupObject == null) defaultGroup = null;
        else defaultGroup = new PermissionGroup(defaultGroupObject);

        groupsObject.keySet().forEach(key -> {
            JSONObject groupObject = groupsObject.optJSONObject(key);
            PermissionGroup group = new PermissionGroup(groupObject);
            groups.put(key, group);
        });
    }

    public boolean isAvailable() {
        return available;
    }

    public Map<String, PermissionGroup> getGroups() {
        return groups;
    }

    public boolean isNotifyService() {
        return notifyService;
    }

    @Nullable
    public PermissionGroup getDefaultGroup() {
        return defaultGroup;
    }

    @Nullable
    @Override
    public File getFile() {
        return file;
    }

}
