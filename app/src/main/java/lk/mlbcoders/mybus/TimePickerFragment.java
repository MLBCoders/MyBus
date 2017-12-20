package lk.mlbcoders.mybus;


import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        String selectedTime = formatDigits(getActualHour(hourOfDay)) + ":" + formatDigits(minute) + " " + getAMPMOfTime(hourOfDay);
        Intent i = new Intent()
                .putExtra("time", selectedTime);
        this.getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
    }

    private String formatDigits(int number){
        String num = String.valueOf(number);
        if(num.length()<2){
            num = "0" + num;
        }
        return num;
    }

    private String getAMPMOfTime(int hour){
        if(hour>12){
            return "PM";
        }
        else
            return "AM";
    }

    private int getActualHour(int hour){
        if(hour>12){
            return hour - 12;
        }
        else
            return hour;
    }
}