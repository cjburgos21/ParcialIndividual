package com.example.javier.parcialindividual;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;


public class fragmento2 extends AppCompatActivity {
    EditText NombreExtra;
    EditText TelefonoExtra;
    EditText CorreoExtra;
    Button BotonAgregar;
    String NombreExtraido, TelefonoExtraido, CorreoExtraido;
    adaptador adapta;
    MainActivity auxiliar;

    //Clase para agregar contacto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragmento2);

        NombreExtra  = (EditText) findViewById(R.id.agregar_nombre);
        TelefonoExtra  = (EditText) findViewById(R.id.agregar_telefono);
        CorreoExtra = (EditText) findViewById(R.id.agregar_correo);
        BotonAgregar = (Button) findViewById(R.id.guarda);


                BotonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context contexto = getApplicationContext();
                NombreExtraido = NombreExtra.getText().toString();
                TelefonoExtraido = TelefonoExtra.getText().toString();
                CorreoExtraido = CorreoExtra.getText().toString();
                Intent intentemos = new Intent(contexto, MainActivity.class);
                intentemos.putExtra("Nombreingresado", NombreExtraido);
                intentemos.putExtra("Telefonoingresado", TelefonoExtraido);
                intentemos.putExtra("Correoingresado", CorreoExtraido);
                intentemos.putExtra("Imageningresada",R.drawable.perfil2);
                startActivity(intentemos);



            }
        });

    }


}

