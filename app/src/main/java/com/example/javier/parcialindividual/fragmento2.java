package com.example.javier.parcialindividual;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
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

    adaptador adapta;
    Context addContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragmento2);

        EditText Nombre = findViewById(R.id.agregar_nombre);
        EditText Telefono = findViewById(R.id.agregar_telefono);
        EditText Correo = findViewById(R.id.agregar_correo);
        ImageView Foto = findViewById(R.id.agregar_imagen);
        Button guardar = findViewById(R.id.guarda);

        final String NombreExtraido = Nombre.getText().toString();
        final String TelefonoExtraido = Telefono.getText().toString();
        final String CorreoExtraido = Correo.getText().toString();

        adapta = new adaptador(this,MainActivity.contact);

        /*
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            MainActivity.contact.add(new Contacto(NombreExtraido,TelefonoExtraido,CorreoExtraido,R.drawable.perfil2));
            adaptador.data.add(new Contacto(NombreExtraido,TelefonoExtraido,CorreoExtraido,R.drawable.perfil2));
            adapta.addingcontact();
            }
        });
        */
    }


}

