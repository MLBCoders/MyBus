package lk.mlbcoders.mybus;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScheduleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment implements OnItemSelectedListener{

    @BindView(R.id.display_result)
    TextView display_result;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    public static ScheduleFragment newInstance() {
        ScheduleFragment fragment = new ScheduleFragment();
        return fragment;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        // On selecting a spinner item
        String item = parent.getItemAtPosition(pos).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_schedule, container, false);

        ButterKnife.bind(this,view);

        return view;
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }*/

    /*@Override
    public void onDetach() {
        super.onDetach();
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
    }

    @OnClick(R.id.btn_find)
    public void showRouteDetails(View button){
        display_result.setText(" Start Location: Kollupitiya \n\t\t\t\t\t\t\t\t Colombo Public Library \n\t\t\t\t\t\t\t\t Kanatta \n\t\t\t\t\t\t\t\t Rajagiriya \n\t\t\t\t\t\t\t\t Ethulkotte \n\t\t\t\t\t\t\t\t Baththaramulla \n\t\t\t\t\t\t\t\t Koswatta \n\t\t\t\t\t\t\t\t Thalahena \n\t\t\t\t\t\t\t\t Malabe \n\t\t\t\t\t\t\t\t Pittugala \n\t\t\t\t\t\t\t\t Kothalawala \n End Location: Kaduwela \n\n\n Other Details: \n Buses Available from 6.00 AM to 8.00 PM daily \n Ticket Price: LKR 35.00 (Normal)/ LKR 80.00 (A/C) \n Journy Time: 45 Mins");
        Log.d("MYBUS","Kollupitiya");
    }
}
