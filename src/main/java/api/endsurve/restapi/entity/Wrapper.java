package api.endsurve.restapi.entity;

import org.json.JSONObject;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class Wrapper {
    private final String serverId;
    private final String hostName;
    private final String version;

    private final boolean ready;

    private final int availableProcessors;
    private final int startPort;
    private final int processQueueSize;
    private final int memory;

    public Wrapper(JSONObject object) {
        serverId = object.optString("serverId");
        hostName = object.optString("hostName");
        version = object.optString("version");
        ready = object.optBoolean("ready");
        availableProcessors = object.optInt("availableProcessors");
        startPort = object.optInt("startPort");
        processQueueSize = object.optInt("process_queue_size");
        memory = object.optInt("memory");
    }

    public String getServerId() {
        return serverId;
    }

    public String getHostName() {
        return hostName;
    }

    public String getVersion() {
        return version;
    }

    public boolean isReady() {
        return ready;
    }

    public int getAvailableProcessors() {
        return availableProcessors;
    }

    public int getStartPort() {
        return startPort;
    }

    public int getProcessQueueSize() {
        return processQueueSize;
    }

    public int getMemory() {
        return memory;
    }

}
