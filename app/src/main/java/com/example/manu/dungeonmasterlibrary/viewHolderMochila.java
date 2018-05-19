package com.example.manu.dungeonmasterlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Manu on 19/05/2018.
 */

public class viewHolderMochila extends RecyclerView.ViewHolder {

    ImageButton btnAddAtack, btnEliminarAtack;
    TextView txtNombreArma;

    public viewHolderMochila(View itemView) {
        super(itemView);

        btnAddAtack = itemView.findViewById(R.id.btnAddAtack);
        btnEliminarAtack = itemView.findViewById(R.id.btnEliminarAtack);
        txtNombreArma = itemView.findViewById(R.id.txtNombreArma);

    }
}
