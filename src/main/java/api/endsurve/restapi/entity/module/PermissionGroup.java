package api.endsurve.restapi.entity.module;

import api.endsurve.restapi.json.JSONArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class PermissionGroup {
    private final String name;
    private final String color;

    private final String prefix;
    private final String suffix;

    private final String display;

    private final int tagId;
    private final int joinPower;

    private final boolean defaultGroup;
    private final Permission[] permissions;
    private final Map<String, String[]> serverGroupPermissions;
    private final Option[] options;
    private final String[] implementGroups;

    public PermissionGroup(JSONObject object) {
        name = object.optString("name");
        color = object.optString("color");

        prefix = object.optString("prefix");
        suffix = object.optString("suffix");

        display = object.optString("display");

        tagId = object.optInt("tagId");
        joinPower = object.optInt("joinPower");

        defaultGroup = object.optBoolean("defaultGroup");

        ArrayList<Permission> permsList = new ArrayList<>();
        JSONObject permsObject = object.optJSONObject("permissions");
        permsObject.keySet().forEach(key -> {
            boolean allowed = permsObject.optBoolean("permissions");
            Permission permission = new Permission(key, allowed);
            permsList.add(permission);
        });
        permissions = permsList.toArray(new Permission[0]);

        serverGroupPermissions = new HashMap<>();
        JSONObject groupPermsObject = object.optJSONObject("serverGroupPermissions");
        groupPermsObject.keySet().forEach(key -> {
            JSONArray permsArray = groupPermsObject.optJSONArray(key);
            String[] perms = JSONArrayUtils.toStringArray(permsArray);
            serverGroupPermissions.put(key, perms);
        });

        ArrayList<Option> optionsList = new ArrayList<>();
        JSONObject optionsObject =  object.optJSONObject("options");
        optionsObject.keySet().forEach(key -> {
            boolean enabled = optionsObject.optBoolean(key);
            optionsList.add(new Option(key, enabled));
        });
        options = optionsList.toArray(new Option[0]);

        JSONArray groupsArray = object.optJSONArray("implementGroups");
        implementGroups = JSONArrayUtils.toStringArray(groupsArray);
    }

}
