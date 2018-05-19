package com.example.manu.dungeonmasterlibrary;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.Adapters.AdapterMochila;
import com.example.manu.dungeonmasterlibrary.POJOS.Objetos;

import java.util.ArrayList;
import java.util.List;

public class MostrarTresPersonajesActivity extends AppCompatActivity {

    static Activity c;
    Objetos objetos;
    MultiSelectionSpinner spinnerBag;
    ArrayList<Objetos> listaObjects;
    RecyclerView recyclerMochila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tres_personajes);

        spinnerBag = findViewById(R.id.spinnerBag);
        recyclerMochila = findViewById(R.id.recyclerMochila);

        c.finish();
        objetos = getIntent().getExtras().getParcelable("ARMAS");
        List<String> list = new ArrayList<String>();
        list.add(objetos.getNombreArma());
        spinnerBag.setItems(list);

        listaObjects.add(objetos);

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

    public static void setActivity(Activity activity){
        MostrarTresPersonajesActivity.c=activity;
    }
}
