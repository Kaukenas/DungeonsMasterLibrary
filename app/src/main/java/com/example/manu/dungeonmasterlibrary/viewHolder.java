package com.example.manu.dungeonmasterlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Manu on 21/03/2018.
 */

public class viewHolder extends RecyclerView.ViewHolder {

    public TextView txtTituloCardView;
    public ImageView imgCardView;

    public viewHolder(View itemView) {
        super(itemView);

        txtTituloCardView = itemView.findViewById(R.id.txtTituloCardView);
        imgCardView = itemView.findViewById(R.id.imageViewCard);
    }
}
