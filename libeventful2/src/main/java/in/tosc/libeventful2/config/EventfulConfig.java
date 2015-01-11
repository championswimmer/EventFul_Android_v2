package in.tosc.libeventful2.config;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by championswimmer on 12/1/15.
 */
public class EventfulConfig {
    static String configJSONString;
    public static enum TopNavigationStyle {
        NAV_DRAWER,
        SPINNER,
        SLIDING,
        SLIDING_TABS
    }
    public static TopNavigationStyle topNavStyle;

    public static void load (Context c) throws IOException, JSONException {
        InputStream is = c.getAssets().open("config.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        configJSONString = new String(buffer, "UTF-8");
        JSONObject configJObj = new JSONObject(configJSONString);
        topNavStyle = loadTopNavStyle(configJObj.getString("top_navigation_type"));
    }

    public static TopNavigationStyle loadTopNavStyle (String s) {
        if (s.equalsIgnoreCase("NAV_DRAWER")) return TopNavigationStyle.NAV_DRAWER;
        if (s.equalsIgnoreCase("NAV_DRAWER")) return TopNavigationStyle.NAV_DRAWER;
        if (s.equalsIgnoreCase("SLIDING")) return TopNavigationStyle.SLIDING;
        if (s.equalsIgnoreCase("SLIDING_TABS")) return TopNavigationStyle.SLIDING_TABS;
        //default
        return TopNavigationStyle.NAV_DRAWER;
    }
}
