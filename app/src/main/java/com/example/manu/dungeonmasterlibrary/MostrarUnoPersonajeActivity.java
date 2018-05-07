package com.example.manu.dungeonmasterlibrary;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MostrarUnoPersonajeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageButton imageButtonDados1;
    double numero = 12.0;
    TextView txtResultadoBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_uno_personaje);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        ViewGroup inclusionViewGroup = findViewById(R.id.linearLayout3);
        imageButtonDados1 = findViewById(R.id.imageButtonDados1);
        txtResultadoBoton = findViewById(R.id.txtResultadoBoton);

        txtResultadoBoton.setText((int) numero);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.combateItem:
                        break;
                    case R.id.habilidadesItem:
                        View child1 = LayoutInflater.from(MostrarUnoPersonajeActivity.this).inflate(
                                R.layout.activity_mostrar_dos_personajes, null);
                        inclusionViewGroup.addView(child1);
                        break;
                    case R.id.equipamientoItem:
                        break;
                    case R.id.rasgosItem:
                        break;
                }
                return true;
            }
        });

        imageButtonDados1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tirarDadosButton();
            }
        });
    }

    public void tirarDadosButton(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Este es el resultado de tu tirada");
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_signin, null));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MostrarUnoPersonajeActivity.this, "Has efectuado tu tirada", Toast.LENGTH_SHORT).show();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();

    }


}
