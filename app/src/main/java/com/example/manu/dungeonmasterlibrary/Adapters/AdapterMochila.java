package com.example.manu.dungeonmasterlibrary.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.MostrarUnoPersonajeActivity;
import com.example.manu.dungeonmasterlibrary.POJOS.Objetos;
import com.example.manu.dungeonmasterlibrary.R;
import com.example.manu.dungeonmasterlibrary.viewHolderMochila;

import java.util.List;

/**
 * Created by Manu on 19/05/2018.
 */

public class AdapterMochila extends RecyclerView.Adapter<viewHolderMochila> {

    List<Objetos> listaObjetos;
    Context context;

    public AdapterMochila(List<Objetos> listaObjetos, Context context) {
        this.listaObjetos = listaObjetos;
        this.context=context;
    }

    @Override
    public viewHolderMochila onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mochila,parent,false);
        return new viewHolderMochila(vista);
    }

    @Override
    public void onBindViewHolder(viewHolderMochila holder, int position) {
        holder.btnEliminarAtack.setOnClickListener(view -> {
            listaObjetos.remove(position);
            notifyDataSetChanged();
        });

        holder.btnAddAtack.setOnClickListener(view -> {
            MostrarUnoPersonajeActivity.listaObjetos.add(listaObjetos.get(position));
            Toast.makeText(context, "Has añadido el objeto: " + listaObjetos.get(position).getNombreArma(), Toast.LENGTH_SHORT).show();
        });

        holder.txtNombreArma.setText(listaObjetos.get(position).getNombreArma());
    }

    @Override
    public int getItemCount() {
        return listaObjetos.size();
    }
}
