package com.example.javier.parcialindividual;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Contacto_activity extends AppCompatActivity {

    private TextView tvnombre, tvtelef,tvcorreo;
    private ImageView imfoto;
    private ImageButton boton_llamar;
    private ImageButton boton_comparte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_activity);

        tvnombre = (TextView) findViewById(R.id.contac_nom);
        tvtelef = (TextView) findViewById(R.id.contac_telef);
        tvcorreo = (TextView) findViewById(R.id.contac_correo);
        imfoto = (ImageView) findViewById(R.id.contact_img);
        boton_llamar = (ImageButton) findViewById(R.id.llama_id);
        boton_comparte = (ImageButton) findViewById(R.id.compartid);



        //Recibiendo informacion

        Intent intenta = getIntent();
        final String Nombre = intenta.getExtras().getString("Nombre");
        final String Telefono = intenta.getExtras().getString("Telefono");
        final String Correo = intenta.getExtras().getString("Correo");
        int foto = intenta.getExtras().getInt("Foto");

        //Seteando valores

        tvnombre.setText(Nombre);
        tvtelef.setText(Telefono);
        tvcorreo.setText(Correo);
        imfoto.setImageResource(foto);

        boton_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent llamar = new Intent(Intent.ACTION_CALL);
                llamar.setData(Uri.parse("tel:"+Telefono));
                v.getContext().startActivity(llamar);
            }
        });



        boton_comparte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compartir = new Intent(Intent.ACTION_SEND);
                compartir = new Intent(Intent.ACTION_SEND);
                compartir.putExtra(Intent.EXTRA_TEXT,"Nombre: "+Nombre+"Telefono:"+Telefono +"Correo:"+Correo);
                compartir.setType("text/plain");
                v.getContext().startActivity(Intent.createChooser(compartir,"Compartir informacion de contacto"));
            }
        });


    }
}
