package com.example.javier.parcialindividual;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Contacto_activity extends AppCompatActivity {

    private TextView tvnombre, tvtelef,tvcorreo;
    private ImageView imfoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_activity);

        tvnombre = (TextView) findViewById(R.id.contac_nom);
        tvtelef = (TextView) findViewById(R.id.contac_telef);
        tvcorreo = (TextView) findViewById(R.id.contac_correo);
        imfoto = (ImageView) findViewById(R.id.contact_img);


        //Recibiendo informacion

        Intent intenta = getIntent();
        String Nombre = intenta.getExtras().getString("Nombre");
        String Telefono = intenta.getExtras().getString("Telefono");
        String Correo = intenta.getExtras().getString("Correo");
        int foto = intenta.getExtras().getInt("Foto");

        //Seteando valores

        tvnombre.setText(Nombre);
        tvtelef.setText(Telefono);
        tvcorreo.setText(Correo);
        imfoto.setImageResource(foto);
    }
}
