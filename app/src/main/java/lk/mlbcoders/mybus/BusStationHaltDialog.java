package lk.mlbcoders.mybus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nirmal on 9/19/17.
 */

public class BusStationHaltDialog extends DialogFragment {
    private ArrayAdapter<String> listAdapter;
    ListView optionList;

    private String selectedItem;
    private View selectedView = null;

    private static final String KEY_TITLE = "title";
    private static final String KEY_OPTIONS = "options";

    /**
     * Create a new instance of a popup dialog
     *
     * @param title         = Title of the new popup dialog
     * @param options_array = Option list of the new popup dialog ( must be a string array )
     * @return = created new instance of popup dialog
     */
    public static BusStationHaltDialog createNewInstance(String title, ArrayList options_array) {
        BusStationHaltDialog popupDialog = new BusStationHaltDialog();
        popupDialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
        Bundle arguments = new Bundle();
        arguments.putString(KEY_TITLE, title);
        arguments.putParcelableArrayList(KEY_OPTIONS, options_array);
        popupDialog.setArguments(arguments);
        return popupDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dialog_popup, container, false);
        ButterKnife.bind(this, rootView);

        String title = getArguments().getString(KEY_TITLE);
        getDialog().setTitle(title);

        optionList = (ListView) rootView.findViewById(R.id.dialog_popup_list_options);

        ArrayList<String> OptionsList = getArguments().getStringArrayList(KEY_OPTIONS);

        listAdapter = new ArrayAdapter<>(getActivity(), R.layout.dialog_popup_row, OptionsList);

        optionList.setAdapter(listAdapter);

        optionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String option = ((TextView) view).getText().toString();
                if (selectedView != null) {
                    selectedView.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                }
                selectedItem = option;
                selectedView = view;
                view.setBackgroundColor(getResources().getColor(R.color.colorMatGrey));
                Log.d("MYBUS", "POPUP DIALOG Selected " + selectedItem);


            }
        });

        return rootView;
    }

    @OnClick(R.id.action_done)
    public void doneClicked(View button) {
        Intent i = null;
        Log.d("MYBUS", "POPUP DIALOG Selected " + selectedItem);
        i = new Intent()
                .putExtra("selected", selectedItem);

        if (this.getTargetFragment() != null) {
            this.getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
        }

        Log.d("MYBUS", "DATA SENT");
        this.dismiss();

    }

    @OnClick(R.id.action_cancel)
    public void cancelClicked(View button) {
        this.dismiss();
    }


}
