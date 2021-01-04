package api.endsurve.restapi.entity;

import org.json.JSONObject;

import java.util.UUID;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class ServiceId {
    private final String group;
    private final int id;
    private final UUID uuid;
    private final String wrapperId;
    private final String serverId;
    private final String gameId;

    public ServiceId(JSONObject object) {
        group = object.optString("group");
        id = object.optInt("id");

        String uuidString = object.optString("uniqueId");
        if (uuidString == null) uuid = null;
        else uuid = UUID.fromString(uuidString);

        wrapperId = object.optString("wrapperId");
        serverId = object.optString("serverId");
        gameId = object.optString("gameId");
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getWrapperId() {
        return wrapperId;
    }

    public String getServerId() {
        return serverId;
    }

    public String getGameId() {
        return gameId;
    }

}
