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
public class Messages implements DataCatcher {
    private final String name;
    private final File file;
    private final String prefix;
    private final String kickMaintenance;
    private final String fullJoin;
    private final String hubCommandNoServerFound;
    private final String joinPowerDeny;
    private final String serverGroupMaintenanceKick;
    private final String mobSelectorMaintenanceMessage;
    private final String notifyMessageServerAdd;
    private final String notifyMessageServerRemove;
    private final String hubAlready;
    private final String serverKickProxyDisallow;
    private final Map<String, Object> allValues;

    public Messages(JSONObject object) {
        name = object.optString("name");

        String fileString = object.optString("file");
        if (fileString == null) file = null;
        else file = new File(fileString);

        JSONObject catcherObject = object.optJSONObject("dataCatcher");
        prefix = catcherObject.optString("prefix");
        kickMaintenance = catcherObject.optString("kick-maintenance");
        fullJoin = catcherObject.optString("full-join");
        hubCommandNoServerFound = catcherObject.optString("hubCommandNoServerFound");
        joinPowerDeny = catcherObject.optString("joinpower-deny");
        serverGroupMaintenanceKick = catcherObject.optString("server-group-maintenance-kick");
        mobSelectorMaintenanceMessage = catcherObject.optString("mob-selector-maintenance-message");
        notifyMessageServerAdd = catcherObject.optString("notify-message-server-add");
        notifyMessageServerRemove = catcherObject.optString("notify-message-server-remove");
        hubAlready = catcherObject.optString("hub-already");
        serverKickProxyDisallow = catcherObject.optString("server-kick-proxy-disallow");

        allValues = new HashMap<>(object.toMap());
    }

    public String getName() {
        return name;
    }

    @Nullable
    @Override
    public File getFile() {
        return file;
    }

    @Override
    public @NotNull Map<String, Object> asMap() {
        return allValues;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getKickMaintenance() {
        return kickMaintenance;
    }

    public String getFullJoin() {
        return fullJoin;
    }

    public String getHubCommandNoServerFound() {
        return hubCommandNoServerFound;
    }

    public String getJoinPowerDeny() {
        return joinPowerDeny;
    }

    public String getServerGroupMaintenanceKick() {
        return serverGroupMaintenanceKick;
    }

    public String getMobSelectorMaintenanceMessage() {
        return mobSelectorMaintenanceMessage;
    }

    public String getNotifyMessageServerAdd() {
        return notifyMessageServerAdd;
    }

    public String getNotifyMessageServerRemove() {
        return notifyMessageServerRemove;
    }

    public String getHubAlready() {
        return hubAlready;
    }

    public String getServerKickProxyDisallow() {
        return serverKickProxyDisallow;
    }

}
