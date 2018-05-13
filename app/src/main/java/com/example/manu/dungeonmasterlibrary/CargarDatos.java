package com.example.manu.dungeonmasterlibrary;

import android.content.Context;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS.Features;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;
import com.example.manu.dungeonmasterlibrary.POJOS.Traits;
import com.example.manu.dungeonmasterlibrary.POJOS2.Razas;
import com.example.manu.dungeonmasterlibrary.POJOS2.Class;
import com.example.manu.dungeonmasterlibrary.POJOS2.Skill;
import com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.CLASSES.GetClassesRetrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Manu on 20/04/2018.
 */

public class CargarDatos {

    Context context;
    ArrayList<Class> listaClases = new ArrayList<>();
    ArrayList<com.example.manu.dungeonmasterlibrary.POJOS2.Razas> listaRazas = new ArrayList<>();

    public CargarDatos(Context context) {
        this.context = context;
    }

    public ArrayList<Class> cargarClases(){


        String baseurl = "http://thedmlibrary.ddns.net/api/index.php/";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GetClassesRetrofit Api = retrofit.create(GetClassesRetrofit.class);

        Call<List<Class>> call = Api.loadChanges();
        call.enqueue(new Callback<List<Class>>() {
            @Override
            public void onResponse(Call<List<Class>> call, Response<List<Class>> response) {
                List<Class> c = response.body();
                for (int i = 0; i <c.size() ; i++) {
                    switch (c.get(i).getId()){
                        case "1":{
                            c.get(i).setFeatures(cargarGuerrero());
                            break;
                        }
                        case "2":{
                            c.get(i).setFeatures(cargarMonje());
                            break;
                        }
                        case "3":{
                            c.get(i).setFeatures(cargarPicaro());
                            break;
                        }
                        case "4":{
                            c.get(i).setFeatures(cargarBarbaro());
                            break;
                        }
                    }
                    listaClases.add(c.get(i));
                }

            }

            @Override
            public void onFailure(Call<List<Class>> call, Throwable t) {

            }
        });
        return listaClases;
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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 4, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 6, Toast.LENGTH_SHORT).show();

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
                Toast.makeText(CargarDatos.this.context, "Mejora Caracteristica" + 8, Toast.LENGTH_SHORT).show();
            }
        };
        listaFeatures.add(f);

        return listaFeatures;
    }

    public ArrayList<Razas> cargarRazas() throws JSONException {


        String baseurl = "http://thedmlibrary.ddns.net/api/index.php/";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GetClassesRetrofit Api = retrofit.create(GetClassesRetrofit.class);

        Call<List<Class>> call = Api.loadChanges();
        call.enqueue(new Callback<List<Class>>() {
            @Override
            public void onResponse(Call<List<Class>> call, Response<List<Class>> response) {
                List<Class> c = response.body();
                for (int i = 0; i <c.size() ; i++) {
                    switch (c.get(i).getId()){
                        case "1":{
                            c.get(i).setFeatures(cargarGuerrero());
                            break;
                        }
                        case "2":{
                            c.get(i).setFeatures(cargarMonje());
                            break;
                        }
                        case "3":{
                            c.get(i).setFeatures(cargarPicaro());
                            break;
                        }
                        case "4":{
                            c.get(i).setFeatures(cargarBarbaro());
                            break;
                        }
                    }
                    listaClases.add(c.get(i));
                }

            }

            @Override
            public void onFailure(Call<List<Class>> call, Throwable t) {

            }
        });
        return listaRazas;
    }

    public ArrayList<Traits> cargarEnano(){
        ArrayList<Traits> listaTraits = new ArrayList<>();
        Traits t = new Traits("aguante enano", "ventaja en tiradas de salvacion contra veneno") {
            @Override
            public void accion() {
                super.accion();
                int numero = (int) (Math.random() * 1) + 19;
                int numero2 = (int) (Math.random() * 1) +19;
                int resultado = 0;
                if (numero > numero2){
                    resultado = numero;
                } else {
                    resultado = numero2;
                }
                Toast.makeText(CargarDatos.this.context, "Tu tirada es de: " + resultado, Toast.LENGTH_SHORT).show();
            }
        };
        listaTraits.add(t);
        t = new Traits("entrenamiento de combate", "Tienes competencia con hacha de batalla, hacha, martillo ligero y martillo de guerra") {};
        listaTraits.add(t);
        t = new Traits("oompetencia con herramientas", "ganas competencia con una de las siguientes herramientas: de herrero, de cervecero, de masoneria") {};
        listaTraits.add(t);
        t = new Traits("afinidad con la piedra", "Siempre que hagas una tirada con trabajos relacionados en piedra tines ventsja") {
            @Override
            public void accion() {
                super.accion();
                int numero = (int) (Math.random() * 1) + 19;
                int numero2 = (int) (Math.random() * 1) +19;
                int resultado = 0;
                if (numero > numero2){
                    resultado = numero;
                } else {
                    resultado = numero2;
                }
                Toast.makeText(CargarDatos.this.context, "Tu tirada es de: " + resultado, Toast.LENGTH_SHORT).show();
            }
        };
        listaTraits.add(t);
        t = new Traits("vision en la oscuridad", "Ves a 60 pies en la oscuridad") {
            @Override
            public void accion() {
                super.accion();
                int numero = (int) (Math.random() * 1) + 19;
                int numero2 = (int) (Math.random() * 1) +19;
                int resultado = 0;
                if (numero > numero2){
                    resultado = numero;
                } else {
                    resultado = numero2;
                }
                Toast.makeText(CargarDatos.this.context, "Tu tirada es de: " + resultado, Toast.LENGTH_SHORT).show();
            }
        };
        listaTraits.add(t);
        return listaTraits;
    }

    public ArrayList<Traits> cargarElfo(){
        ArrayList<Traits> listaTraits = new ArrayList<>();
        Traits t = new Traits("sentidos agudos", "eres competente con la habilidad percepcion") {
            public void accion(Character p) {
                super.accion();
                List<Skill> h = p.getSkills();
                h.add(new Skill("percepcion"));
                p.setSkills(h);
            }
        };
        listaTraits.add(t);
        t = new Traits("origen feerico", "Ventaja en tiradas de dormir") {
            public void accion() {
                super.accion();
                int numero = (int) (Math.random() * 1) + 19;
                int numero2 = (int) (Math.random() * 1) +19;
                int resultado = 0;
                if (numero > numero2){
                    resultado = numero;
                } else {
                    resultado = numero2;
                }
                Toast.makeText(CargarDatos.this.context, "Tu tirada es de: " + resultado, Toast.LENGTH_SHORT).show();
            }
        };
        listaTraits.add(t);
        t = new Traits("trance", "no necesitas dormir, solo meditar 4 horas") {};
        listaTraits.add(t);
        t = new Traits("vision en la oscuridad", "Ves a 60 pies en la oscuridad") {
            @Override
            public void accion() {
                super.accion();
                int numero = (int) (Math.random() * 1) + 19;
                int numero2 = (int) (Math.random() * 1) +19;
                int resultado = 0;
                if (numero > numero2){
                    resultado = numero;
                } else {
                    resultado = numero2;
                }
                Toast.makeText(CargarDatos.this.context, "Tu tirada es de: " + resultado, Toast.LENGTH_SHORT).show();
            }
        };
        listaTraits.add(t);
        return listaTraits;
    }

}
