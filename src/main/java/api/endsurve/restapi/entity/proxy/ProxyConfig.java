package api.endsurve.restapi.entity.proxy;

import api.endsurve.restapi.json.JSONArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class ProxyConfig {
    private final String maintenanceProtocol;
    private final int maxPlayers;

    private final boolean enabled;
    private final boolean maintenance;
    private final boolean customPayloadFixer;

    private final MotdLayout[] motdsLayouts;
    private final MotdLayout maintenanceMotdLayout;

    private final String[] playerInfo;
    private final String[] whitelist;

    private final AutoSlot autoSlot;
    private final Tablist tablist;
    private final DynamicFallback fallback;
    private final ProxyGroupMode mode;

    private final Map<String, Object> settings;

    public ProxyConfig(JSONObject object) {
        maintenanceProtocol = object.optString("maintenaceProtocol");
        maxPlayers = object.optInt("maxPlayers");

        enabled = object.optBoolean("enabled");
        maintenance = object.optBoolean("maintenance");
        customPayloadFixer = object.optBoolean("customPayloadFixer");

        ArrayList<MotdLayout> layouts = new ArrayList<>();
        JSONArray layoutArray = object.optJSONArray("motdsLayouts");
        for (int i = 0; i < layoutArray.length(); i++) {
            JSONObject layoutObject = layoutArray.optJSONObject(i);
            if (layoutObject == null) continue;
            layouts.add(new MotdLayout(layoutObject));
        }
        motdsLayouts = layouts.toArray(new MotdLayout[0]);

        JSONArray infoArray = object.optJSONArray("playerInfo");
        playerInfo = JSONArrayUtils.toStringArray(infoArray);

        JSONArray whitelistArray = object.optJSONArray("whitelist");
        whitelist = JSONArrayUtils.toStringArray(whitelistArray);

        JSONObject layoutObject = object.optJSONObject("maintenanceMotdLayout");
        maintenanceMotdLayout = new MotdLayout(layoutObject);

        JSONObject autoSlotObject = object.optJSONObject("autoSlot");
        autoSlot = new AutoSlot(autoSlotObject);

        JSONObject tablistObject = object.optJSONObject("tabList");
        tablist = new Tablist(tablistObject);

        mode = object.optEnum(ProxyGroupMode.class, "proxyGroupMode");

        JSONObject fallbackJSON = object.optJSONObject("dynamicFallback");
        fallback = new DynamicFallback(fallbackJSON);

        settings = object.optJSONObject("settings").toMap();
    }

    public String getMaintenanceProtocol() {
        return maintenanceProtocol;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isMaintenance() {
        return maintenance;
    }

    public boolean isCustomPayloadFixer() {
        return customPayloadFixer;
    }

    public MotdLayout[] getMotdsLayouts() {
        return motdsLayouts;
    }

    public MotdLayout getMaintenanceMotdLayout() {
        return maintenanceMotdLayout;
    }

    public String[] getPlayerInfo() {
        return playerInfo;
    }

    public String[] getWhitelist() {
        return whitelist;
    }

    public AutoSlot getAutoSlot() {
        return autoSlot;
    }

    public Tablist getTablist() {
        return tablist;
    }

    public DynamicFallback getFallback() {
        return fallback;
    }

    public ProxyGroupMode getMode() {
        return mode;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }

}
