package in.tosc.libeventful2.fragments.about;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.tosc.libeventful2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutOnePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutOnePageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TITLE = "title";
    private static final String ARG_SUMMARY = "summary";

    // TODO: Rename and change types of parameters
    private String mTitle;
    private String mSummary;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Title of "About Us"
     * @param summary  Text contained in "About Us"
     * @return A new instance of fragment AboutOnePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutOnePageFragment newInstance(String title, String summary) {
        AboutOnePageFragment fragment = new AboutOnePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_SUMMARY, summary);
        fragment.setArguments(args);
        return fragment;
    }

    public AboutOnePageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_TITLE);
            mSummary = getArguments().getString(ARG_SUMMARY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_about_one_page, container, false);
        TextView aboutSummary = (TextView) rootView.findViewById(R.id.about_summary);
        aboutSummary.setText(mSummary);
        return rootView;
    }

}
