package api.endsurve.restapi;

import api.endsurve.restapi.auth.StandardBridgeAuth;
import api.endsurve.restapi.entity.Wrapper;
import api.endsurve.restapi.entity.proxy.ProxyGroup;
import api.endsurve.restapi.entity.server.ServerGroup;
import api.endsurve.restapi.http.TemplateHTTPRequests;
import api.endsurve.restapi.http.response.APIResponse;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class RestAPIBridge {
    private static StandardBridgeAuth auth;

    public static void login(String user, String token) {
        auth = new StandardBridgeAuth(user, token);
    }

    public static void logout() {
        auth = null;
    }

    public static List<ServerGroup> getServerGroups() throws Exception {
        ArrayList<ServerGroup> groups = new ArrayList<>();
        APIResponse response = TemplateHTTPRequests.utilAPI(auth);
        JSONObject object = response.getResponse();
        JSONObject groupsObject = object.optJSONObject("serverGroups");
        groupsObject.keySet().forEach(key -> {
            JSONObject groupObject = groupsObject.optJSONObject(key);
            ServerGroup group = new ServerGroup(groupObject);
            groups.add(group);
        });
        return groups;
    }

    public static List<ProxyGroup> getProxyGroups() throws Exception {
        ArrayList<ProxyGroup> groups = new ArrayList<>();
        APIResponse response = TemplateHTTPRequests.utilAPI(auth);
        JSONObject object = response.getResponse();
        JSONObject groupsObject = object.optJSONObject("proxyGroups");
        groupsObject.keySet().forEach(key -> {
            JSONObject groupObject = groupsObject.optJSONObject(key);
            ProxyGroup group = new ProxyGroup(groupObject);
            groups.add(group);
        });
        return groups;
    }

    public static List<Wrapper> getWrappers() throws Exception {
        ArrayList<Wrapper> wrappers = new ArrayList<>();
        APIResponse response = TemplateHTTPRequests.utilAPI(auth);
        JSONObject object = response.getResponse();
        JSONObject wrappersObject = object.optJSONObject("wrappers");
        wrappersObject.keySet().forEach(key -> {
            JSONObject wrapperObject = wrappersObject.optJSONObject(key);
            Wrapper wrapper = new Wrapper(wrapperObject);
            wrappers.add(wrapper);
        });
        return wrappers;
    }

    public static int getModulesWebPort() throws Exception {
        APIResponse response = TemplateHTTPRequests.utilAPI(auth);
        JSONObject object = response.getResponse();
        JSONObject modulesObject = object.optJSONObject("modules");
        return modulesObject.optInt("webPort");
    }

    public static int getOnlineCount() throws Exception {
        APIResponse response = TemplateHTTPRequests.utilAPI(auth);
        JSONObject object = response.getResponse();
        return object.optInt("onlineCount");
    }

    public static int getRegisteredPlayerCount() throws Exception {
        APIResponse response = TemplateHTTPRequests.utilAPI(auth);
        JSONObject object = response.getResponse();
        return object.optInt("registeredPlayerCount");
    }

}
