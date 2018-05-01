package com.example.javier.parcialindividual;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class fragmento2 extends DialogFragment {
    implements DatePickerDialog.OnDateSetListener{


        private DatePickerDialog.OnDateSetListener listener;

        public static fragmento2 newInstance(DatePickerDialog.OnDateSetListener listener){
            fragmento2 fragmento  = new fragmento2();
            fragmento.setListener(listener);
            return fragmento;

        }

        @Override

                public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar c = Calendar.getInstance();
            int año = c.get(Calendar.YEAR);
            int mes = c.get(Calendar.MONTH);
            int dia = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this,año ,mes, dia);

        }

        public void onDateSet(DatePicker view, int año, int mes, int dia){

        }


    }

    private void showDatePickerDialog() {
        fragmento2 newFragment = fragmento2.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                etPlannedDate.setText(selectedDate);
            }
        });
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }


    public void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }
}
