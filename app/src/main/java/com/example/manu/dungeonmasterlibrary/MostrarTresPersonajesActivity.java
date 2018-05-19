package com.example.manu.dungeonmasterlibrary;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tres_personajes);
        addObject = findViewById(R.id.btnAddObject);
        spinnerBag = findViewById(R.id.spinnerBag);
        recyclerMochila = findViewById(R.id.recyclerMochila);

        c.finish();
        objetos = getIntent().getExtras().getParcelable("ARMAS");
        List<String> list = new ArrayList<String>();
        list.add(objetos.getNombreArma());
        spinnerBag.setItems(list);
        spinnerBag.setMax(1);
        Toast.makeText(c, objetos.getNombreArma(), Toast.LENGTH_SHORT).show();
        listaObjects.add(objetos);
        listaObjects.add(objetos);
        listaObjects.add(objetos);
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
    }

    public static void setActivity(Activity activity){
        MostrarTresPersonajesActivity.c=activity;
    }
}
