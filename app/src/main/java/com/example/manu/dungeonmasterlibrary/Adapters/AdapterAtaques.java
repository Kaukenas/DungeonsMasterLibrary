package com.example.manu.dungeonmasterlibrary.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manu.dungeonmasterlibrary.MostrarUnoPersonajeActivity;
import com.example.manu.dungeonmasterlibrary.POJOS.Objetos;
import com.example.manu.dungeonmasterlibrary.R;
import com.example.manu.dungeonmasterlibrary.viewHolderAtaques;
import com.example.manu.dungeonmasterlibrary.viewHolderMochila;

import java.awt.font.TextAttribute;
import java.util.List;

/**
 * Created by Manu on 19/05/2018.
 */

public class AdapterAtaques extends RecyclerView.Adapter<viewHolderAtaques> {

    List<Objetos> listaObjetos;
    Context context;
    LayoutInflater inflater;
    TextView txtResultadoTirada;

    public AdapterAtaques(List<Objetos> listaObjetos, Context context, LayoutInflater inflater) {
        this.listaObjetos = listaObjetos;
        this.context=context;
        this.inflater=inflater;
    }

    @Override
    public viewHolderAtaques onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ataques,parent,false);
        return new viewHolderAtaques(vista);
    }

    @Override
    public void onBindViewHolder(viewHolderAtaques holder, int position) {
        holder.txtAtack.setText(listaObjetos.get(position).getNombreArma());
        holder.btnDadosTirada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = MyCustomAlertDialog(listaObjetos.get(position).getCaras());
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public AlertDialog MyCustomAlertDialog(int caras){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = inflater;
        View mylayout =layoutInflater.inflate(R.layout.dialog_signin, null);
        txtResultadoTirada =  mylayout.findViewById(R.id.txtResultadoTirada);
        int tirada=tirarDado(caras);
        txtResultadoTirada.setText(""+tirada);
        builder.setView(mylayout).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }

    public int tirarDado(int rango) {
        double resultado;
        resultado=Math.random()*rango;
        return (int)resultado;
    }

}
