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

    public fragmento2(){

    }

        private DatePickerDialog.OnDateSetListener listener;

        public static fragmento2 newInstance(DatePickerDialog.OnDateSetListener listener){
            fragmento2 fragmento  = new fragmento2();
            fragmento.setListener(listener);
            return fragmento;

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

            return inflater.inflate(R.layout.fragment_fragmento2, container, false);
        }









    public void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

}


