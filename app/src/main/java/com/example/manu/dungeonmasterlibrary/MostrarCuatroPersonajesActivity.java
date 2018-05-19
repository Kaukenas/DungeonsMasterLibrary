package com.example.manu.dungeonmasterlibrary;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MostrarCuatroPersonajesActivity extends AppCompatActivity {

    static Activity c;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_cuatro_personajes);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.rasgosItem);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.combateItem:
                        Intent intent = new Intent(MostrarCuatroPersonajesActivity.this,MostrarUnoPersonajeActivity.class);
                        intent.putExtras(getIntent().getExtras());
                        MostrarUnoPersonajeActivity.setActivity(MostrarCuatroPersonajesActivity.this);
                        startActivity(intent);
                        break;
                    case R.id.habilidadesItem:
                        Intent intentHab = new Intent(MostrarCuatroPersonajesActivity.this,MostrarDosPersonajesActivity.class);
                        intentHab.putExtras(getIntent().getExtras());
                        MostrarDosPersonajesActivity.setActivity(MostrarCuatroPersonajesActivity.this);
                        startActivity(intentHab);
                        break;
                    case R.id.equipamientoItem:
                        Intent intentEqui = new Intent(MostrarCuatroPersonajesActivity.this,MostrarTresPersonajesActivity.class);
                        intentEqui.putExtras(getIntent().getExtras());
                        MostrarTresPersonajesActivity.setActivity(MostrarCuatroPersonajesActivity.this);
                        startActivity(intentEqui);
                        break;
                    case R.id.rasgosItem:
                        break;
                }
                return true;
            }
        });

    }
    public static void setActivity(Activity activity){
        MostrarCuatroPersonajesActivity.c=activity;
    }
}
