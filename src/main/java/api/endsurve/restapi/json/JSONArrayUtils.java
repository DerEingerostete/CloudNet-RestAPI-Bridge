package api.endsurve.restapi.json;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class JSONArrayUtils {

    public static String[] toStringArray(JSONArray array) {
        if (array == null) return new String[0];
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            String string = array.optString(i);
            list.add(string);
        }
        return list.toArray(new String[0]);
    }

}
