package lk.mlbcoders.mybus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchBusFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchBusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchBusFragment extends Fragment {

    public static final int JOURNEY_FROM = 1;
    public static final int JOURNEY_TO = 2;
    public static final int TIME_FROM = 3;
    public static final int TIME_TO = 4;

    private String mParam1;
    private String mParam2;

    public SearchBusFragment() {
        // Required empty public constructor
    }

    /**
     * Default instance constructor
     * @return
     */
    public static SearchBusFragment newInstance() {
        SearchBusFragment fragment = new SearchBusFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_search_bus, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.btn_search_bus_route)
    public void btnSearchBusRouteClicked(View button){
        Log.d("MYBUS","Btn search clicked");
        Toast.makeText(getActivity(),"Searching bus route",Toast.LENGTH_SHORT).show();
    }

    private Fragment getThisFragment(){
        return this;
    }

    @OnClick(R.id.picker_journey_from)
    public void pickerJourneyFromClicked(View button){
        Log.d("MYBUS","Journey from clicked");
        Toast.makeText(getActivity(),"Select Journey from",Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.picker_journey_to)
    public void pickerJourneyToClicked(View button){
        Log.d("MYBUS","Journey to clicked");
        Toast.makeText(getActivity(),"Select Journey to",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.picker_time_range_from)
    public void pickerTimeRangeFromClicked(View button){
        Log.d("MYBUS","Time range from clicked");
        Toast.makeText(getActivity(),"Select time range from",Toast.LENGTH_SHORT).show();
        DialogFragment timePicker = new TimePickerFragment();
        timePicker.setTargetFragment(getThisFragment(), TIME_FROM);
        timePicker.show(getActivity().getSupportFragmentManager(),"FromTimePicker");

    }

    @OnClick(R.id.picker_time_range_to)
    public void pickerTimeRangeToClicked(View button){
        Log.d("MYBUS","Time range to clicked");
        Toast.makeText(getActivity(),"Select time range to",Toast.LENGTH_SHORT).show();
        DialogFragment timePicker = new TimePickerFragment();
        timePicker.setTargetFragment(getThisFragment(), TIME_TO);
        timePicker.show(getActivity().getSupportFragmentManager(),"ToTimePicker");

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case JOURNEY_FROM:
                    break;
                case JOURNEY_TO:
                    break;
                case TIME_FROM:
                    Bundle fromTimeBundle = data.getExtras();
                    String selectedFromTime = fromTimeBundle.getString("time");
                    Toast.makeText(getActivity(),"Selected from time : " + selectedFromTime,Toast.LENGTH_SHORT).show();
                    break;
                case TIME_TO:
                    Bundle toTimeBundle = data.getExtras();
                    String selectedToTime = toTimeBundle.getString("time");
                    Toast.makeText(getActivity(),"Selected to time : " + selectedToTime,Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
