package api.endsurve.restapi.entity.module;

import api.endsurve.restapi.entity.DataCatcher;
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
public class PermissionPool implements DataCatcher {
    private final boolean available;
    private final Map<String, PermissionGroup> groups;
    private PermissionGroup defaultGroup;
    private final boolean notifyService;
    private final File file;
    private final Map<String, Object> allValues;

    public PermissionPool(JSONObject object, JSONObject dataCatcherObject) {
        available = object.optBoolean("available");
        notifyService = dataCatcherObject.optBoolean("notifyService");

        String fileString = object.optString("file");
        if (fileString == null) file = null;
        else file = new File(fileString);

        groups = new HashMap<>();
        JSONObject groupsObject = object.optJSONObject("groups");

        groupsObject.keySet().forEach(key -> {
            JSONObject groupObject = groupsObject.optJSONObject(key);
            PermissionGroup group = new PermissionGroup(groupObject);
            groups.put(key, group);
        });

        groups.forEach((name, group) -> {
            if (group.isDefaultGroup())
                defaultGroup = group;
        });

        allValues = new HashMap<>(object.toMap());
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

    @Override
    public @NotNull Map<String, Object> asMap() {
        return allValues;
    }

    @Nullable
    @Override
    public File getFile() {
        return file;
    }
}
