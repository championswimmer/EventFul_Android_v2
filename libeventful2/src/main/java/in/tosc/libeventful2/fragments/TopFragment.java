package in.tosc.libeventful2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.tosc.libeventful2.R;
import in.tosc.libeventful2.config.EventfulConfig;

/**
 * A placeholder fragment containing a simple view.
 */
public class TopFragment extends Fragment {
    public static final String TAG = "TopFragment";

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public TopFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TopFragment newInstance(int sectionNumber) {
        TopFragment fragment = new TopFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(EventfulConfig.DEBUG) Log.d(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_top, container, false);
        TextView label = (TextView) rootView.findViewById(R.id.section_label);
        label.setText("OMGWTF" + getArguments().getInt(ARG_SECTION_NUMBER));
        return rootView;
    }
}