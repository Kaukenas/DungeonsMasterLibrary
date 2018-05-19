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
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.Adapters.AdapterMochila;
import com.example.manu.dungeonmasterlibrary.POJOS.Objetos;

import java.util.ArrayList;
import java.util.List;

public class MostrarTresPersonajesActivity extends AppCompatActivity {

    static Activity c;
    Objetos objetos;
    MultiSelectionSpinner spinnerBag;
    ArrayList<Objetos> listaObjects = new ArrayList<>();
    RecyclerView recyclerMochila;
    Button addObject;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tres_personajes);
        addObject = findViewById(R.id.btnAddObject);
        spinnerBag = findViewById(R.id.spinnerBag);
        recyclerMochila = findViewById(R.id.recyclerMochila);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        c.finish();
        bottomNavigationView.setSelectedItemId(R.id.equipamientoItem);
        objetos = getIntent().getExtras().getParcelable("ARMAS");
        List<String> list = new ArrayList<String>();
        list.add(objetos.getNombreArma());
        spinnerBag.setItems(list);
        spinnerBag.setMax(1);
        Toast.makeText(c, objetos.getNombreArma(), Toast.LENGTH_SHORT).show();
        listaObjects.add(objetos);

        addObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0; i < listaObjects.size(); i++){
                    if(listaObjects.get(i).getNombreArma().equals(MostrarTresPersonajesActivity.this.spinnerBag.obtenerSeleccion().get(0))){
                        Toast.makeText(MostrarTresPersonajesActivity.this, "UE", Toast.LENGTH_SHORT).show();
                        objetos = listaObjects.get(i);
                    }
                }
                recyclerMochila.setAdapter(new AdapterMochila(listaObjects,MostrarTresPersonajesActivity.this));
                recyclerMochila.setHasFixedSize(true);
                LinearLayoutManager layoutManagerr = new LinearLayoutManager(getApplicationContext());
                layoutManagerr.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerMochila.setLayoutManager(layoutManagerr);
            }
        });

        //Toast.makeText(c, listaObjects.size(), Toast.LENGTH_SHORT).show();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.combateItem:
                        Intent intent = new Intent(MostrarTresPersonajesActivity.this,MostrarUnoPersonajeActivity.class);
                        intent.putExtras(getIntent().getExtras());
                        MostrarUnoPersonajeActivity.setActivity(MostrarTresPersonajesActivity.this);
                        startActivity(intent);
                        break;
                    case R.id.habilidadesItem:
                        Intent intentHab = new Intent(MostrarTresPersonajesActivity.this,MostrarDosPersonajesActivity.class);
                        intentHab.putExtras(getIntent().getExtras());
                        MostrarDosPersonajesActivity.setActivity(MostrarTresPersonajesActivity.this);
                        startActivity(intentHab);
                        break;
                    case R.id.equipamientoItem:
                        break;
                    case R.id.rasgosItem:
                        Intent intentRas = new Intent(MostrarTresPersonajesActivity.this,MostrarCuatroPersonajesActivity.class);
                        intentRas.putExtras(getIntent().getExtras());
                        MostrarCuatroPersonajesActivity.setActivity(MostrarTresPersonajesActivity.this);
                        startActivity(intentRas);
                        break;
                }
                return true;
            }
        });
    }



    public static void setActivity(Activity activity){
        MostrarTresPersonajesActivity.c=activity;
    }
}
