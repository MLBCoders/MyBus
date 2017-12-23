package lk.mlbcoders.mybus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchBusFragment extends Fragment {

    public static final int JOURNEY_FROM = 1;
    public static final int JOURNEY_TO = 2;
    public static final int TIME_FROM = 3;
    public static final int TIME_TO = 4;

    @BindView(R.id.picker_journey_from) TextInputEditText picker_journey_from;
    @BindView(R.id.picker_journey_to) TextInputEditText picker_journey_to;
    @BindView(R.id.picker_time_range_from) TextInputEditText picker_time_range_from;
    @BindView(R.id.picker_time_range_to) TextInputEditText picker_time_range_to;

    ArrayList<Button> dateBtns = new ArrayList<>();

    FragmentManager fm;
    ArrayList<String> busHalts = new ArrayList<>();


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

        resetBusHaltList();

        int[] dateBts = {R.id.btn_date_mon,R.id.btn_date_tue,R.id.btn_date_wed,R.id.btn_date_Thu,R.id.btn_date_Fri,R.id.btn_date_Sat,R.id.btn_date_Sun};
        for (int i = 0 ; i<dateBts.length ; i++){
            ((Button) view.findViewById(dateBts[i])).getBackground().setColorFilter(ContextCompat.getColor(getContext(), R.color.colorDateBtnUnSelected), PorterDuff.Mode.MULTIPLY);
            ((Button) view.findViewById(dateBts[i])).setTextColor(getResources().getColor(R.color.colorBlack));
        }

        fm = getActivity().getSupportFragmentManager();

        return view;
    }

    public void resetBusHaltList(){
        busHalts.clear();
        busHalts.add("Kaduwela");
        busHalts.add("Kothalawala");
        busHalts.add("Pittugala");
        busHalts.add("Malabe");
        busHalts.add("Thalahena");
        busHalts.add("Koswatta");
        busHalts.add("Battaramulla");
        busHalts.add("Rajagiriya");
        busHalts.add("Kollupitiya");
    }

    @OnClick(R.id.btn_search_bus_route)
    public void btnSearchBusRouteClicked(View button){
        Log.d("MYBUS","Btn search clicked");
        Toast.makeText(getActivity(),"Searching bus route",Toast.LENGTH_SHORT).show();

        SearchbusDetailsFragment searchbusDetailsFragment = new SearchbusDetailsFragment();
        Bundle args = new Bundle();
        args.putInt("result_count",1);
        args.putString("route_no","177");
        args.putString("start_location",picker_journey_from.getText().toString());
        args.putString("end_location",picker_journey_to.getText().toString());
        args.putString("type","Daily");
        args.putString("start_time",picker_time_range_from.getText().toString());
        args.putString("end_time",picker_time_range_to.getText().toString());
        args.putString("duration","40 min");
        fm.beginTransaction().replace(R.id.search_bus_main_frame, searchbusDetailsFragment).addToBackStack(null).commit();
    }

    private Fragment getThisFragment(){
        return this;
    }

    @OnClick(R.id.picker_journey_from)
    public void pickerJourneyFromClicked(View button){
        Log.d("MYBUS","Journey from clicked");
        Toast.makeText(getActivity(),"Select Journey from",Toast.LENGTH_SHORT).show();
        resetBusHaltList();
        if(picker_journey_to.length()>0){
            busHalts.remove(picker_journey_to.getText().toString());
        }
        BusStationHaltDialog busStationHaltDialog = BusStationHaltDialog.createNewInstance("Select Journey Start",busHalts);
        busStationHaltDialog.setTargetFragment(getThisFragment(), JOURNEY_FROM);
        busStationHaltDialog.show(fm,"BusHaltJourneyFrom");
    }

    @OnClick(R.id.picker_journey_to)
    public void pickerJourneyToClicked(View button){
        Log.d("MYBUS","Journey to clicked");
        Toast.makeText(getActivity(),"Select Journey to",Toast.LENGTH_SHORT).show();
        resetBusHaltList();
        if(picker_journey_from.length()>0){
            busHalts.remove(picker_journey_from.getText().toString());
        }
        BusStationHaltDialog busStationHaltDialog = BusStationHaltDialog.createNewInstance("Select Journey End",busHalts);
        busStationHaltDialog.setTargetFragment(getThisFragment(), JOURNEY_TO);
        busStationHaltDialog.show(fm,"BusHaltJourneyTo");
    }

    @OnClick(R.id.picker_time_range_from)
    public void pickerTimeRangeFromClicked(View button){
        Log.d("MYBUS","Time range from clicked");
        Toast.makeText(getActivity(),"Select time range from",Toast.LENGTH_SHORT).show();
        DialogFragment timePicker = new TimePickerFragment();
        timePicker.setTargetFragment(getThisFragment(), TIME_FROM);
        timePicker.show(fm,"FromTimePicker");
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
                    Bundle fromJourneyBundle = data.getExtras();
                    String selectedFromJourney = fromJourneyBundle.getString("selected");
                    Toast.makeText(getActivity(),"Selected from journey : " + selectedFromJourney,Toast.LENGTH_SHORT).show();
                    picker_journey_from.setText(selectedFromJourney);
                    break;
                case JOURNEY_TO:
                    Bundle toJourneyBundle = data.getExtras();
                    String selectedToJourney = toJourneyBundle.getString("selected");
                    Toast.makeText(getActivity(),"Selected to journey : " + selectedToJourney,Toast.LENGTH_SHORT).show();
                    picker_journey_to.setText(selectedToJourney);
                    break;
                case TIME_FROM:
                    Bundle fromTimeBundle = data.getExtras();
                    String selectedFromTime = fromTimeBundle.getString("time");
                    Toast.makeText(getActivity(),"Selected from time : " + selectedFromTime,Toast.LENGTH_SHORT).show();
                    picker_time_range_from.setText(selectedFromTime);
                    break;
                case TIME_TO:
                    Bundle toTimeBundle = data.getExtras();
                    String selectedToTime = toTimeBundle.getString("time");
                    Toast.makeText(getActivity(),"Selected to time : " + selectedToTime,Toast.LENGTH_SHORT).show();
                    picker_time_range_to.setText(selectedToTime);
                    break;
            }
        }
    }

    @OnClick({R.id.btn_date_mon,R.id.btn_date_tue,R.id.btn_date_wed,R.id.btn_date_Thu,R.id.btn_date_Fri,R.id.btn_date_Sat,R.id.btn_date_Sun})
    public void btnDateMonClicked(Button button){
        Log.d("MYBUS","btn date selected : " + button.getText().toString());
        if(!dateBtns.contains(button)){
            dateBtns.add(button);
            button.getBackground().setColorFilter(ContextCompat.getColor(getContext(), R.color.colorDateBtnSelected), PorterDuff.Mode.MULTIPLY);
            button.setTextColor(getResources().getColor(R.color.colorCreamWhite));
        }else{
            dateBtns.remove(button);
            button.getBackground().setColorFilter(ContextCompat.getColor(getContext(), R.color.colorDateBtnUnSelected), PorterDuff.Mode.MULTIPLY);
            button.setTextColor(getResources().getColor(R.color.colorBlack));
        }
    }
}
