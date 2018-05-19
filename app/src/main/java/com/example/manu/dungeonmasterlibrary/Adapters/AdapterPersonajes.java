package com.example.manu.dungeonmasterlibrary.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.MostrarUnoPersonajeActivity;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;
import com.example.manu.dungeonmasterlibrary.POJOS.Personajes;
import com.example.manu.dungeonmasterlibrary.POJOS.Pruebafotos;
import com.example.manu.dungeonmasterlibrary.PersonajesActivity;
import com.example.manu.dungeonmasterlibrary.R;
import com.example.manu.dungeonmasterlibrary.viewHolder;

import java.util.List;

/**
 * Created by Manu on 21/03/2018.
 */

public class AdapterPersonajes extends RecyclerView.Adapter<viewHolder> {

    List<Character> listaPersonajes;
    Context context;

    public AdapterPersonajes(List<Character> listaPersonajes, Context context) {
        this.listaPersonajes = listaPersonajes;
        this.context=context;
    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new viewHolder(vista);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        //holder.txtTituloCardView.setText(listaObjetos.get(position).getTitulo());
        //holder.imgCardView.setImageResource(listaObjetos.get(position).getImagen());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Ramon siempre tiene razon", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MostrarUnoPersonajeActivity.class);
                Bundle bundle = new Bundle();
                Character c =listaPersonajes.get(position);
                Toast.makeText(context, ""+c.getAbilities().get(0).getFuerza(), Toast.LENGTH_SHORT).show();
                bundle.putParcelable("PERSONAJE", c);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        byte[] decodedString = Base64.decode(listaPersonajes.get(position).getPhoto(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        holder.imgCardView.setImageBitmap(decodedByte);
        holder.txtTituloCardView.setText(listaPersonajes.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }
}
