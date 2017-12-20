package lk.mlbcoders.mybus;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by user on 12/20/2017.
 */

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        month += 1;
        String selectedDate = formatDigits(day) + "-" + formatDigits(month) + "-" + year;
        Intent i = new Intent()
                .putExtra("date", selectedDate);
        this.getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
    }

    private String formatDigits(int number){
        String num = String.valueOf(number);
        if(num.length()<2){
            num = "0" + num;
        }
        return num;
    }
}