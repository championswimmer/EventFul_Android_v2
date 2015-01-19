package in.tosc.libeventful2.config;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by championswimmer on 19/1/15.
 */
public class EventfulConfigAbout {
    public static String title;
    public static String summary;

    public static void loadAbout(JSONObject aboutJObj) throws JSONException {
        title = aboutJObj.getString("title");
        summary = aboutJObj.getString("summary");
    }
}
