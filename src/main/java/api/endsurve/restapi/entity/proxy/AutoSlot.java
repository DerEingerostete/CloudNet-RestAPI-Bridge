package api.endsurve.restapi.entity.proxy;

import org.json.JSONObject;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class AutoSlot {
    private final int dynamicSlotSize;
    private final boolean enabled;

    public AutoSlot(JSONObject object) {
        dynamicSlotSize = object.optInt("dynamicSlotSize");
        enabled = object.optBoolean("dynamicSlotSize");
    }

    public int getDynamicSlotSize() {
        return dynamicSlotSize;
    }

    public boolean isEnabled() {
        return enabled;
    }

}
