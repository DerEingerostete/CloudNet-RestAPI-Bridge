package api.endsurve.restapi.entity.server;

import api.endsurve.restapi.entity.ServiceId;
import api.endsurve.restapi.entity.Template;
import api.endsurve.restapi.json.JSONArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class Server {
    private final String name;
    private final ServiceId serviceId;
    private final String host;
    private final int port;
    private final boolean online;
    private final String[] players;
    private final int memory;
    private final String motd;
    private final int onlineCount;
    private final int maxPlayers;
    private final ServerState state;
    private final Template template;
    private final ServerConfig config;

    public Server(String name, JSONObject object) {
        this.name = name;
        JSONObject serviceObject = object.optJSONObject("serviceId");
        serviceId = new ServiceId(serviceObject);

        host = object.optString("host");
        port = object.optInt("port");
        online = object.optBoolean("online");

        JSONArray playersArray = object.optJSONArray("players");
        players = JSONArrayUtils.toStringArray(playersArray);

        memory = object.optInt("memory");
        motd = object.optString("motd");
        onlineCount = object.optInt("onlineCount");
        maxPlayers = object.optInt("maxPlayers");

        state = object.getEnum(ServerState.class, "serverState");

        JSONObject templateObject = object.optJSONObject("template");
        template = new Template(templateObject);

        JSONObject configObject = object.optJSONObject("serverConfig");
        config = new ServerConfig(configObject);
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

    public String getMotd() {
        return motd;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public ServerState getState() {
        return state;
    }

    public Template getTemplate() {
        return template;
    }

    public ServerConfig getConfig() {
        return config;
    }

}
