package com.example.manu.dungeonmasterlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Manu on 20/05/2018.
 */

public class viewHolderHabilidades extends RecyclerView.ViewHolder {

    public TextView txtItemHab;
    public ImageButton btnDadosHab;

    public viewHolderHabilidades(View itemView) {
        super(itemView);

        btnDadosHab = itemView.findViewById(R.id.btnDadosHab);
        txtItemHab = itemView.findViewById(R.id.txtItemHab);
    }
}
