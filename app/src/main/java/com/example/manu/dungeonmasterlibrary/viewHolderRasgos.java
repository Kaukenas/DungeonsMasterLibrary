package com.example.manu.dungeonmasterlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Manu on 20/05/2018.
 */

public class viewHolderRasgos extends RecyclerView.ViewHolder {

    public TextView txtItemRas;
    public ImageButton btnDadosRas;

    public viewHolderRasgos(View itemView) {
        super(itemView);

        btnDadosRas = itemView.findViewById(R.id.btnDadosRas);
        txtItemRas = itemView.findViewById(R.id.txtItemRas);
    }
}
