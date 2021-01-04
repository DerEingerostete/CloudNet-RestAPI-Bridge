package api.endsurve.restapi.entity.proxy;

import api.endsurve.restapi.entity.ServiceId;
import api.endsurve.restapi.json.JSONArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class Proxy {
    private final String name;
    private final ServiceId serviceId;
    private final String host;
    private final int port;
    private final boolean online;
    private final String[] players;
    private final int memory;
    private final int onlineCount;

    public Proxy(String name, JSONObject object) {
        this.name = name;

        JSONObject serviceObject = object.optJSONObject("serviceId");
        serviceId = new ServiceId(serviceObject);

        host = object.optString("host");
        port = object.optInt("port");
        online = object.optBoolean("online");

        JSONArray playersArray = object.optJSONArray("players");
        players = JSONArrayUtils.toStringArray(playersArray);

        memory = object.optInt("memory");
        onlineCount = object.optInt("onlineCount");
    }

    @NotNull
    public String getName() {
        return name;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public boolean isOnline() {
        return online;
    }

    public String[] getPlayers() {
        return players;
    }

    public int getMemory() {
        return memory;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

}
