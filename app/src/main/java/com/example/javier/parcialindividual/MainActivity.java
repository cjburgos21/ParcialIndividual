package com.example.javier.parcialindividual;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contacto> contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact = new ArrayList<>();

        String[] projeccion = new String[] { ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.TYPE };

        String selectionClause = ContactsContract.Data.MIMETYPE + "='" +
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND "
                + ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL";

        String sortOrder = ContactsContract.Data.DISPLAY_NAME + " ASC";

        Cursor c = getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                projeccion,
                selectionClause,
                null,
                sortOrder);

        while(c.moveToNext()){
            contact.add(new Contacto(c.getString(1),c.getString(2),"000000@uca.edu.sv",R.drawable.perfil2));
        }
        c.close();


        RecyclerView rcyv = (RecyclerView) findViewById(R.id.recycler1);
        adaptador adapta = new adaptador(this,contact);
        rcyv.setLayoutManager(new GridLayoutManager(this,3));
        rcyv.setAdapter(adapta);

    }
}
