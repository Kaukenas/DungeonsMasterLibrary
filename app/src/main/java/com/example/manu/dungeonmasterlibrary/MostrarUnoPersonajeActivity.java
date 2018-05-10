package com.example.manu.dungeonmasterlibrary;

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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MostrarUnoPersonajeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageButton imageButtonDados1, imageButtonDados2,imageButtonDados3,imageButtonDados4,
            imageButtonDados5,imageButtonDados6,imageButtonDados7;
    TextView txtResultadoTirada;
    Button yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_uno_personaje);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        imageButtonDados1 = findViewById(R.id.imageButtonDados1);
        imageButtonDados2 = findViewById(R.id.imageButtonDados2);
        imageButtonDados3 = findViewById(R.id.imageButtonDados3);
        imageButtonDados4 = findViewById(R.id.imageButtonDados4);
        imageButtonDados5 = findViewById(R.id.imageButtonDados5);
        imageButtonDados6 = findViewById(R.id.imageButtonDados6);
        imageButtonDados7 = findViewById(R.id.imageButtonDados7);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.combateItem:
                        //setContentView(R.layout.activity_mostrar_uno_personaje);
                        break;
                    case R.id.habilidadesItem:
                        setContentView(R.layout.activity_mostrar_dos_personajes);
                        break;
                    case R.id.equipamientoItem:
                        setContentView(R.layout.activity_mostrar_tres_personajes);
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
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });

        imageButtonDados7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog =MyCustomAlertDialog();
                dialog.show();
            }
        });
    }

    public int tirarDado(int rango) {
        double resultado;
        resultado=Math.random()*rango;
        return (int)resultado;
    }

    public AlertDialog MyCustomAlertDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View mylayout =layoutInflater.inflate(R.layout.dialog_signin, null);
        txtResultadoTirada =  mylayout.findViewById(R.id.txtResultadoTirada);
        int tirada=tirarDado(20);
        txtResultadoTirada.setText(""+tirada);
        builder.setView(mylayout).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
        /*
        myDialog = new Dialog(MostrarUnoPersonajeActivity.this);
        myDialog.setContentView(R.layout.dialog_signin);
        myDialog.setTitle("My custom dialog");
        yes = myDialog.findViewById(R.id.btn_yes);
        no = myDialog.findViewById(R.id.btn_no);
        txtResultadoTirada = findViewById(R.id.txtResultadoTirada);

        int tirada=1;
        txtResultadoTirada.setText(""+tirada);


        yes.setEnabled(true);
        no.setEnabled(true);

        myDialog.show();
        */
    }

}
