package com.example.manu.dungeonmasterlibrary.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.MostrarUnoPersonajeActivity;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;
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
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, MostrarUnoPersonajeActivity.class);
            Bundle bundle = new Bundle();
            Character c =listaPersonajes.get(position);
            bundle.putParcelable("PERSONAJE", c);
            intent.putExtras(bundle);
            context.startActivity(intent);
        });

        holder.imgCardView.setImageResource(R.drawable.barbaro);
        holder.txtTituloCardView.setText(listaPersonajes.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }
}
