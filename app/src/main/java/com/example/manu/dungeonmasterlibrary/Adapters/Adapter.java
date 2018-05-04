package com.example.manu.dungeonmasterlibrary.Adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manu.dungeonmasterlibrary.POJOS.Personajes;
import com.example.manu.dungeonmasterlibrary.POJOS.Pruebafotos;
import com.example.manu.dungeonmasterlibrary.R;
import com.example.manu.dungeonmasterlibrary.viewHolder;

import java.util.List;

/**
 * Created by Manu on 21/03/2018.
 */

public class Adapter extends RecyclerView.Adapter<viewHolder> {

    List<Personajes> listaPersonajes;

    public Adapter(List<Personajes> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
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
        byte[] decodedString = Base64.decode(listaPersonajes.get(position).getFotoPersonaje(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        holder.imgCardView.setImageBitmap(decodedByte);
        holder.txtTituloCardView.setText(listaPersonajes.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }
}
