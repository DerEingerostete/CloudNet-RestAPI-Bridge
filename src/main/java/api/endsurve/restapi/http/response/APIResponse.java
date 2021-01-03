package api.endsurve.restapi.http.response;

import api.endsurve.restapi.json.JSONArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class APIResponse {
    private final boolean success;
    private final String[] reason;
    private final JSONObject response;

    public APIResponse(JSONObject object) {
        success = object.optBoolean("success");

        JSONArray reasonArray = object.optJSONArray("reason");
        reason = JSONArrayUtils.toStringArray(reasonArray);

        response = object.optJSONObject("response");
    }

    public boolean wasSuccessfully() {
        return success;
    }

    public String[] getReason() {
        return reason;
    }

    public JSONObject getResponse() {
        return response;
    }
}
