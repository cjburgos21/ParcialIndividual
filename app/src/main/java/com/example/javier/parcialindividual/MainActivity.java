package com.example.javier.parcialindividual;

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
        contact.add(new Contacto("Carlos Burgos", "70143865","cjburgos12@hotmail.com",R.drawable.perfil2));
        contact.add(new Contacto("Javier Martinez", "74149036","crls@hotmail.com",R.drawable.perfil2));
        contact.add(new Contacto("Roberto Cuestas", "76521922","rcuestas9@hotmail.com",R.drawable.perfil2));
        contact.add(new Contacto("Gerardo Alvarado", "77693452","galvarado1@hotmail.com",R.drawable.perfil2));


        RecyclerView rcyv = (RecyclerView) findViewById(R.id.recycler1);
        adaptador adapta = new adaptador(this,contact);
        rcyv.setLayoutManager(new GridLayoutManager(this,3));
        rcyv.setAdapter(adapta);

    }
}
