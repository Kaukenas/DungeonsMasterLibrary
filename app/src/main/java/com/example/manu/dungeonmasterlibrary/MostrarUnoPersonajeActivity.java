package com.example.manu.dungeonmasterlibrary;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MostrarUnoPersonajeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_uno_personaje);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        ViewGroup inclusionViewGroup = findViewById(R.id.linearLayout3);

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
    }
}
