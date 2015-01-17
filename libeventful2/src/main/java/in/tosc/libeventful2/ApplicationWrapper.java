package in.tosc.libeventful2;

import android.app.Application;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;

import in.tosc.libeventful2.activities.TopExtendableActivity;
import in.tosc.libeventful2.config.EventfulConfig;

/**
 * Created by championswimmer on 17/1/15.
 */
public class ApplicationWrapper extends Application {
    public static final String TAG = "ApplicationWrapper";

    public static String[] topSectionTitles;
    public static int topSectionCount;
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            EventfulConfig.load(getApplicationContext());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        if (EventfulConfig.DEBUG) Log.d(TAG,
                EventfulConfig.numTopFrags + "" +
                        EventfulConfig.topFragmentTitles.length + EventfulConfig.topFragmentTitles[0]);

        topSectionCount = EventfulConfig.numTopFrags;
        topSectionTitles = EventfulConfig.topFragmentTitles;

    }
}
