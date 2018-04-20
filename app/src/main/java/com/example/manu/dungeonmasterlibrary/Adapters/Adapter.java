package com.example.manu.dungeonmasterlibrary.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manu.dungeonmasterlibrary.POJOS.Pruebafotos;
import com.example.manu.dungeonmasterlibrary.R;
import com.example.manu.dungeonmasterlibrary.viewHolder;

import java.util.List;

/**
 * Created by Manu on 21/03/2018.
 */

public class Adapter extends RecyclerView.Adapter<viewHolder> {

    List<Pruebafotos> listaObjetos;

    public Adapter(List<Pruebafotos> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new viewHolder(vista);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        holder.txtTituloCardView.setText(listaObjetos.get(position).getTitulo());
        holder.imgCardView.setImageResource(listaObjetos.get(position).getImagen());

    }

    @Override
    public int getItemCount() {
        return listaObjetos.size();
    }
}
