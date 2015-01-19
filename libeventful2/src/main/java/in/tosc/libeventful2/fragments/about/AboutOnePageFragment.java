package in.tosc.libeventful2.fragments.about;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.tosc.libeventful2.R;
import in.tosc.libeventful2.config.EventfulConfig;
import in.tosc.libeventful2.config.EventfulConfigAbout;
import in.tosc.libeventful2.fragments.TopFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutOnePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutOnePageFragment extends TopFragment {
    public static final String TAG = "AboutOnePageFragment";

    public static AboutOnePageFragment newInstance() {
        return new AboutOnePageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(EventfulConfig.DEBUG) Log.d(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_about_one_page, container, false);
        TextView summaryText = (TextView) rootView.findViewById(R.id.about_summary);
        summaryText.setText(EventfulConfigAbout.summary);

        return rootView;
    }
}
