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

import com.example.manu.dungeonmasterlibrary.POJOS.Features;
import com.example.manu.dungeonmasterlibrary.POJOS.Objetos;
import com.example.manu.dungeonmasterlibrary.POJOS2.Ability;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;
import com.example.manu.dungeonmasterlibrary.POJOS2.Trait;
import com.example.manu.dungeonmasterlibrary.R;
import com.example.manu.dungeonmasterlibrary.viewHolderAtaques;
import com.example.manu.dungeonmasterlibrary.viewHolderRasgos;

import java.util.List;

/**
 * Created by Manu on 19/05/2018.
 */

public class AdapterRasgos extends RecyclerView.Adapter<viewHolderRasgos> {

    List<Features> listaRasgos;
    Context context;
    LayoutInflater inflater;
    TextView txtResultadoTirada;

    public AdapterRasgos(List<Features> listaRasgos, Context context, LayoutInflater inflater) {
        this.listaRasgos = listaRasgos;
        this.context=context;
        this.inflater = inflater;
    }

    @Override
    public viewHolderRasgos onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rasgos,parent,false);
        return new viewHolderRasgos(vista);
    }

    @Override
    public void onBindViewHolder(viewHolderRasgos holder, int position) {
        holder.txtItemRas.setText(listaRasgos.get(position).getNombre());
        holder.btnDadosRas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = MyCustomAlertDialog(20);
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
