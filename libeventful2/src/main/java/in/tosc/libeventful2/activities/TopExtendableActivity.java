package in.tosc.libeventful2.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import in.tosc.libeventful2.R;
import in.tosc.libeventful2.fragments.TopFragment;

/**
 * Created by championswimmer on 4/1/15.
 */
public class TopExtendableActivity extends ActionBarActivity {

    //TODO: Get this data from configs, not hardcode
    String[] topSectionTitles = {"Section 1", "Section Two", "Sec 3"};
    int topSectionCount = 3;
//    TopFragment[] topFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        We are using the dynamic method generateFragment below to generate fragments in the fly instead of this
//        topFragments = new TopFragment[]{
//                TopFragment.newInstance(1),
//                TopFragment.newInstance(2),
//                TopFragment.newInstance(3)
//        };
    }

    protected TopFragment generateFragment (int position) {
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
