package api.endsurve.restapi.entity.proxy;

import org.json.JSONObject;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class MotdLayout {
    private final String firstLine;
    private final String secondLine;
    private final String[] lines;

    public MotdLayout(JSONObject object) {
        firstLine = object.optString("firstLine");
        secondLine = object.optString("secondLine");
        lines = new String[] {firstLine, secondLine};
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public String[] getLines() {
        return lines;
    }

}
