package com.example.manu.dungeonmasterlibrary;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.Adapters.AdapterHabilidades;
import com.example.manu.dungeonmasterlibrary.Adapters.AdapterRasgos;
import com.example.manu.dungeonmasterlibrary.POJOS.Features;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;
import com.example.manu.dungeonmasterlibrary.POJOS2.Skill;
import com.example.manu.dungeonmasterlibrary.POJOS2.Trait;

import java.util.ArrayList;
import java.util.List;

public class MostrarCuatroPersonajesActivity extends AppCompatActivity {

    static Activity c;
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerRasgos;
    List<Features> listaRasgos = new ArrayList<>();
    Character personaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerRasgos = findViewById(R.id.recyclerRasgos);

        personaje = getIntent().getExtras().getParcelable("PERSONAJE");

        setContentView(R.layout.activity_mostrar_cuatro_personajes);
        c.finish();
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

        listaRasgos = personaje.getaClass().getFeatures();

        Toast.makeText(this, "RASGOS " + personaje.getaClass(), Toast.LENGTH_SHORT).show();

        /*recyclerRasgos.setAdapter(new AdapterRasgos(listaRasgos,MostrarCuatroPersonajesActivity.this, this.getLayoutInflater()));
        recyclerRasgos.setHasFixedSize(true);
        LinearLayoutManager layoutManagerr = new LinearLayoutManager(getApplicationContext());
        layoutManagerr.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerRasgos.setLayoutManager(layoutManagerr);*/

    }
    public static void setActivity(Activity activity){
        MostrarCuatroPersonajesActivity.c=activity;
    }
}
