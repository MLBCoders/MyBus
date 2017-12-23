package lk.mlbcoders.mybus;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchbusDetailsFragment extends DialogFragment {


    @BindView(R.id.txt_results_found) TextView txt_results_found;
    @BindView(R.id.txt_details_route_no) TextView txt_details_route_no;
    @BindView(R.id.txt_details_start_location) TextView txt_details_start_location;
    @BindView(R.id.txt_details_end_location) TextView txt_details_end_location;
    @BindView(R.id.txt_details_type) TextView txt_details_type;
    @BindView(R.id.txt_details_start_time) TextView txt_details_start_time;
    @BindView(R.id.txt_details_end_time) TextView txt_details_end_time;
    @BindView(R.id.txt_details_duration) TextView txt_details_duration;

    public SearchbusDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_search_bus_details, container, false);
        ButterKnife.bind(this,view);

        String result_count = String.valueOf(getArguments().getInt("result_count"));
        txt_results_found.setText(result_count);

        String route_no = getArguments().getString("route_no");
        txt_details_route_no.setText(result_count);

        String start_location = getArguments().getString("start_location");
        txt_details_start_location.setText(result_count);

        String end_location = getArguments().getString("end_location");
        txt_details_end_location.setText(result_count);

        String type = getArguments().getString("type");
        txt_details_type.setText(result_count);

        String start_time = getArguments().getString("start_time");
        txt_details_start_time.setText(result_count);

        String end_time = getArguments().getString("end_time");
        txt_details_end_time.setText(result_count);

        String duration = getArguments().getString("duration");
        txt_details_duration.setText(result_count);

        return view;
    }


    @OnClick(R.id.btn_show_map)
    public void btnShowMap(View button){
        Intent intent = new Intent(getActivity(), MapsActivity.class);
        startActivity(intent);
    }

}
