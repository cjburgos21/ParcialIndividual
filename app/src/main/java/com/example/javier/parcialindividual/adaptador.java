package com.example.javier.parcialindividual;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/** Se crean metodos para setear informacion en cardviews
 * @author aws1994
 *
 *
 *
 */


public class adaptador extends RecyclerView.Adapter<adaptador.MyViewHolder>{

    private Context context1;
    public static List<Contacto> data;

    public adaptador(Context context1, List<Contacto> data) {
        this.context1 = context1;
        this.data = data;
    }

    //Seteando informacion a cada uno de los cardview
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context1);
        view = inflater.inflate(R.layout.cardview1,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.txt_nom.setText(data.get(position).getNombre());
        holder.img.setImageResource(data.get(position).getFoto());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intenta = new Intent(context1,Contacto_activity.class);


                //Transfiriendo datos a Contacto_activity
                intenta.putExtra("Nombre",data.get(position).getNombre());
                intenta.putExtra("Telefono",data.get(position).getTelefono());
                intenta.putExtra("Correo",data.get(position).getCorreo());
                intenta.putExtra("Foto",data.get(position).getFoto());

                context1.startActivity(intenta);

            }
        });

        //Seteando click Listener


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void filterList(List<Contacto> filteredList) {
        data = filteredList;
        notifyDataSetChanged();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_nom;
        ImageView img;
        CardView cardView;
        EditText NombreExtraido;



        public MyViewHolder(View itemView) {
            super(itemView);
            NombreExtraido = (EditText) itemView.findViewById(R.id.agregar_nombre);
            txt_nom = (TextView) itemView.findViewById(R.id.txt1);
            img = (ImageView)  itemView.findViewById(R.id.img1);
            cardView = (CardView) itemView.findViewById(R.id.cardv_id);
        }
    }


}
