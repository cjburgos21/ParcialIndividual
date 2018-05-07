package com.example.javier.parcialindividual;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.graphics.BitmapFactory;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contacto> contact;
    List<Contacto> FilteredList;
    String nombres, tel, correoe;
    TextView nombre1,telefono,correo1;
    ImageView imagen1;
    private String contactID;
    adaptador adapta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen1 = (ImageView) findViewById(R.id.contact_img);


        contact = new ArrayList<>();

        String[] pro = new String[] { ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.TYPE };

        String selectionClause = ContactsContract.Data.MIMETYPE + "='" +
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND "
                + ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL";

        String sortOrder = ContactsContract.Data.DISPLAY_NAME + " ASC";

        Cursor c = getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                pro,
                selectionClause,
                null,
                sortOrder);

        while(c.moveToNext()){
            contact.add(new Contacto(c.getString(1),c.getString(2),"000000@uca.edu.sv",R.drawable.perfil2));
        }
        c.close();

        RecyclerView rcyv = (RecyclerView) findViewById(R.id.recycler1);
        adapta = new adaptador(this,contact);
        rcyv.setLayoutManager(new GridLayoutManager(this,2));
        rcyv.setAdapter(adapta);


        EditText buscador = (EditText) findViewById(R.id.buscar);
        buscador.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


    }


    private void filter(String text) {
        ArrayList<Contacto> filteredList = new ArrayList<>();

        for (Contacto item : contact) {
            if (item.getNombre().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        adapta.filterList(filteredList);
    }
    


    //Importando imagenes de contacto
    private void retrieveContactPhoto() {

        Bitmap photo = null;

        try {
            InputStream inputStream = ContactsContract.Contacts.openContactPhotoInputStream(getContentResolver(),

                    ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long.valueOf(contactID)));


            //Seteando Foto importada de telefono en ImageView
            if (inputStream != null) {
                photo = BitmapFactory.decodeStream(inputStream);
                ImageView imageView = (ImageView) findViewById(R.id.img1);
                imageView.setImageBitmap(photo);
            }

            assert inputStream != null;
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//CREANDO CLASE COMPARTIR


    public void compartir(View view) {
        Bitmap bitmap1 = vista(imagen1);
        nombre1 = (TextView) findViewById(R.id.contac_nom);
        nombres = nombre1.getText().toString();
        telefono = (TextView) findViewById(R.id.contac_telef);
        tel = telefono.getText().toString();
        correo1 = (TextView) findViewById(R.id.contac_correo);
        correoe = correo1.getText().toString();



        //Declarando intent

        try {
            File file = new File(this.getExternalCacheDir(), "apoyo.png");
            FileOutputStream fuera = new FileOutputStream(file);
            bitmap1.compress(Bitmap.CompressFormat.PNG,100,fuera);
            fuera.flush();
            fuera.close();
            file.setReadable(true, false);
            final Intent comparte = new Intent(android.content.Intent.ACTION_SEND);
            comparte.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            comparte.setType("");
            comparte.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            comparte.putExtra(Intent.EXTRA_TEXT, "Nombre:" + nombres + "\n" + tel + "\n" + correoe);
            /*Permite escoger la app para recibir la informacion*/

            startActivity(Intent.createChooser(comparte,"Que programa desea utilizar?"));

        } catch (Exception e) {
            e.printStackTrace();


        }
    }


    //Generador de imagen

    private Bitmap vista(View view){
        Bitmap retorna = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas1 = new Canvas(retorna);
        Drawable imag = view.getBackground();

        if(imag !=null){
            imag.draw(canvas1);
        }else{
            canvas1.drawColor(Color.WHITE);

        }
        view.draw(canvas1);
        return retorna;
    }


}



