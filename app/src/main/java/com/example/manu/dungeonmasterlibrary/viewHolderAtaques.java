package com.example.manu.dungeonmasterlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Manu on 19/05/2018.
 */

public class viewHolderAtaques  extends RecyclerView.ViewHolder {

    public TextView txtAtack;
    public ImageButton btnDadosTirada;

    public viewHolderAtaques(View itemView) {
        super(itemView);

        btnDadosTirada = itemView.findViewById(R.id.btnDadosTirada);
        txtAtack = itemView.findViewById(R.id.txtAtack);
    }
}
