package in.tosc.libeventful2.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import in.tosc.libeventful2.R;
import in.tosc.libeventful2.config.EventfulConfig;
import in.tosc.libeventful2.fragments.TopFragment;

/**
 * Created by championswimmer on 4/1/15.
 */
public class TopExtendableActivity extends ActionBarActivity {
    public static final String TAG = "TopExtendableActivity";

    public static String[] topSectionTitles = {"About", "Contact Us"};
    public static int topSectionCount = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (EventfulConfig.DEBUG) Log.d(TAG,
                EventfulConfig.numTopFrags + "" +
                        EventfulConfig.topFragmentTitles.length + EventfulConfig.topFragmentTitles[0]);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected TopFragment generateFragment(int position) {
        return TopFragment.newInstance(position + 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
