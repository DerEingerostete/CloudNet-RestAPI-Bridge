package api.endsurve.restapi.entity.proxy;

import api.endsurve.restapi.json.JSONArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class ProxyGroup {
    private final String name;
    private final String[] wrappers;
    private final String proxyVersion;

    private final ProxyTemplate template;
    private final ProxyConfig config;

    private final int startupPort;
    private final int startup;
    private final int memory;

    public ProxyGroup(JSONObject object) {
        name = object.optString("name");

        JSONArray wrapperArray = object.optJSONArray("wrapper");
        wrappers = JSONArrayUtils.toStringArray(wrapperArray);

        proxyVersion = object.optString("proxyVersion");

        JSONObject templateObject = object.optJSONObject("template");
        template = new ProxyTemplate(templateObject);

        JSONObject configObject = object.optJSONObject("proxyConfig");
        config = new ProxyConfig(templateObject);

        startupPort = object.optInt("startupPort");
        startup = object.optInt("startup");
        memory = object.optInt("memory");
    }

    public String getName() {
        return name;
    }

    public String[] getWrappers() {
        return wrappers;
    }

    public String getProxyVersion() {
        return proxyVersion;
    }

    public ProxyTemplate getTemplate() {
        return template;
    }

    public ProxyConfig getConfig() {
        return config;
    }

    public int getStartupPort() {
        return startupPort;
    }

    public int getStartup() {
        return startup;
    }

    public int getMemory() {
        return memory;
    }

}
