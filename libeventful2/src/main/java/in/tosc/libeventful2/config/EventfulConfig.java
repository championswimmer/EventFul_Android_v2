package in.tosc.libeventful2.config;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by championswimmer on 12/1/15.
 */

public class EventfulConfig {
    public static final String TAG = "EventfulConfig";
    // Custom data types
    public static enum TopNavigationStyle {
        NAVDRAWER,
        SPINNER,
        SLIDING,
        SLIDING_TABS
    }
    public static enum TopFragmentType {
        ABOUT,
        CONTACT,
        INVALID
    }
    // Internally used variables
    static JSONObject configJObj;


    // Config data storage variables
    public static boolean DEBUG = false;
    public static TopNavigationStyle topNavStyle;
    public static int numTopFrags = 0;
    public static HashMap<Integer, TopFragmentType> topFragments;

    public static void load (Context c) throws IOException, JSONException {
        InputStream is = c.getAssets().open("config.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        configJObj  = new JSONObject(new String(buffer, "UTF-8"));
        DEBUG = configJObj.getBoolean("debug");
        Log.d(TAG, "Inflating eventful config with debugging : " + DEBUG);

        topNavStyle = loadTopNavStyle(configJObj.getString("top_navigation_type"));
        if (DEBUG) Log.d(TAG, "Top level navigation style : " + topNavStyle);

        JSONArray topFragJSONArray = configJObj.getJSONArray("top_navigation_fragments");
        numTopFrags = topFragJSONArray.length();
        if(DEBUG) Log.d(TAG, "Number of top level fragments to be made  = " + numTopFrags);
        topFragments = new HashMap<>(numTopFrags);
        for (int i = 0; i < numTopFrags; i++) {
            TopFragmentType fragType = loadFragType(topFragJSONArray.getString(i));
            if (DEBUG) Log.d(TAG, i + " " + fragType);
            topFragments.put(i, fragType);
        }
    }

    public static TopNavigationStyle loadTopNavStyle (String s) {
        if (s.equalsIgnoreCase("NAVDRAWER")) return TopNavigationStyle.NAVDRAWER;
        if (s.equalsIgnoreCase("SPINNER")) return TopNavigationStyle.SPINNER;
        if (s.equalsIgnoreCase("SLIDING")) return TopNavigationStyle.SLIDING;
        if (s.equalsIgnoreCase("SLIDING_TABS")) return TopNavigationStyle.SLIDING_TABS;
        //default
        return TopNavigationStyle.NAVDRAWER;
    }
    public static TopFragmentType loadFragType (String s) {
        if (s.equalsIgnoreCase("ABOUT")) return TopFragmentType.ABOUT;
        if (s.equalsIgnoreCase("CONTACT")) return TopFragmentType.CONTACT;
        //default
        return TopFragmentType.INVALID;
    }
}
