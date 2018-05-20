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

        switch (personaje.getaClass().getId()){
            case "1":{
                personaje.getaClass().setFeatures(cargarGuerrero());
                break;
            }
            case "2":{
                personaje.getaClass().setFeatures(cargarMonje());
                break;
            }
            case "3":{
                personaje.getaClass().setFeatures(cargarPicaro());
                break;
            }
            case "4":{
                personaje.getaClass().setFeatures(cargarBarbaro());
                break;
            }
        }

        listaRasgos = personaje.getaClass().getFeatures();

        Toast.makeText(this, "RASGOS " + personaje.getaClass().getFeatures().get(0).getNombre(), Toast.LENGTH_SHORT).show();

        recyclerRasgos.setAdapter(new AdapterRasgos(listaRasgos,MostrarCuatroPersonajesActivity.this, this.getLayoutInflater()));
        recyclerRasgos.setHasFixedSize(true);
        LinearLayoutManager layoutManagerr = new LinearLayoutManager(getApplicationContext());
        layoutManagerr.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerRasgos.setLayoutManager(layoutManagerr);

    }
    public static void setActivity(Activity activity){
        MostrarCuatroPersonajesActivity.c=activity;
    }

    public ArrayList<Features> cargarGuerrero() {
        ArrayList<Features> listaFeatures = new ArrayList<>();
        Features f = new Features("Estilo de combate","Descripcion de Estilo de Combate",false,"CA",1) {
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features("Nuevas Energias","Descripcion de Nuevas Energias",true,"HEAL",1) {
            public void accion(Character p) {
                super.accion();
                p.setVida(p.getVida()+5);
            }
        };
        listaFeatures.add(f);
        f = new Features("Oleada de Accion", "Descripcion de Oleada de Accion", true, "NULL",2) {
            @Override
            public void accion() {
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features("Arquetipo Marcial", "Descripcion de Arquetipo Marcial", false, "DAMAGE",3) {
            public void accion(Character p) {
                super.accion();
                p.setDAMAGE(p.getDAMAGE()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",4){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Ataque Extra", "Descripcion de Ataque Extra", true, "NULL",5){
            public void accion(){
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",6){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

            }
        };
        listaFeatures.add(f);
        f = new Features ("Estilo Combate 2", "Descripcion de Estilo Combate 2", false, "CA",7){
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+2);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",8){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);

        return listaFeatures;
    }

    public ArrayList<Features> cargarMonje() {
        ArrayList<Features> listaFeatures = new ArrayList<>();
        Features f = new Features("Estilo de combate","Descripcion de Estilo de Combate",false,"CA",1) {
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features("Nuevas Energias","Descripcion de Nuevas Energias",true,"HEAL",1) {
            public void accion(Character p) {
                super.accion();
                p.setVida(p.getVida()+5);
            }
        };
        listaFeatures.add(f);
        f = new Features("Oleada de Accion", "Descripcion de Oleada de Accion", true, "NULL",2) {
            @Override
            public void accion() {
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features("Arquetipo Marcial", "Descripcion de Arquetipo Marcial", false, "DAMAGE",3) {
            public void accion(Character p) {
                super.accion();
                p.setDAMAGE(p.getDAMAGE()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",4){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Ataque Extra", "Descripcion de Ataque Extra", true, "NULL",5){
            public void accion(){
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",6){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

            }
        };
        listaFeatures.add(f);
        f = new Features ("Estilo Combate 2", "Descripcion de Estilo Combate 2", false, "CA",7){
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+2);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",8){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);

        return listaFeatures;
    }

    public ArrayList<Features> cargarPicaro() {
        ArrayList<Features> listaFeatures = new ArrayList<>();
        Features f = new Features("Estilo de combate","Descripcion de Estilo de Combate",false,"CA",1) {
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features("Nuevas Energias","Descripcion de Nuevas Energias",true,"HEAL",1) {
            public void accion(Character p) {
                super.accion();
                p.setVida(p.getVida()+5);
            }
        };
        listaFeatures.add(f);
        f = new Features("Oleada de Accion", "Descripcion de Oleada de Accion", true, "NULL",2) {
            @Override
            public void accion() {
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features("Arquetipo Marcial", "Descripcion de Arquetipo Marcial", false, "DAMAGE",3) {
            public void accion(Character p) {
                super.accion();
                p.setDAMAGE(p.getDAMAGE()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",4){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Ataque Extra", "Descripcion de Ataque Extra", true, "NULL",5){
            public void accion(){
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",6){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

            }
        };
        listaFeatures.add(f);
        f = new Features ("Estilo Combate 2", "Descripcion de Estilo Combate 2", false, "CA",7){
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+2);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",8){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);

        return listaFeatures;
    }

    public ArrayList<Features> cargarBarbaro() {
        ArrayList<Features> listaFeatures = new ArrayList<>();
        Features f = new Features("Estilo de combate","Descripcion de Estilo de Combate",false,"CA",1) {
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features("Nuevas Energias","Descripcion de Nuevas Energias",true,"HEAL",1) {
            public void accion(Character p) {
                super.accion();
                p.setVida(p.getVida()+5);
            }
        };
        listaFeatures.add(f);
        f = new Features("Oleada de Accion", "Descripcion de Oleada de Accion", true, "NULL",2) {
            @Override
            public void accion() {
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features("Arquetipo Marcial", "Descripcion de Arquetipo Marcial", false, "DAMAGE",3) {
            public void accion(Character p) {
                super.accion();
                p.setDAMAGE(p.getDAMAGE()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",4){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Ataque Extra", "Descripcion de Ataque Extra", true, "NULL",5){
            public void accion(){
                super.accion();
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",6){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

            }
        };
        listaFeatures.add(f);
        f = new Features ("Estilo Combate 2", "Descripcion de Estilo Combate 2", false, "CA",7){
            public void accion(Character p) {
                super.accion();
                p.setCA(p.getCA()+2);
            }
        };
        listaFeatures.add(f);
        f = new Features ("Mejora Caracteristica", "Descripcion de Mejora Caracteristica", true, "NULL",8){
            public void accion(){
                super.accion();
                Toast.makeText(getApplicationContext(), "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);

        return listaFeatures;
    }
}
