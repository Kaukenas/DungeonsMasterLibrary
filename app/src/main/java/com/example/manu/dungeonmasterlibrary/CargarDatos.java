package com.example.manu.dungeonmasterlibrary;

import android.content.Context;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS.Clases;
import com.example.manu.dungeonmasterlibrary.POJOS.Features;
import com.example.manu.dungeonmasterlibrary.POJOS.Personajes;
import com.example.manu.dungeonmasterlibrary.POJOS.Razas;
import com.example.manu.dungeonmasterlibrary.POJOS.Traits;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Manu on 20/04/2018.
 */

public class CargarDatos {

    Context context;

    public CargarDatos(Context context) {
        this.context = context;
    }

    public ArrayList<Clases> cargarClases() throws JSONException {
        cargarFeatures();
        ArrayList<Clases> listaClases = new ArrayList<>();
        JSONObject tiradasSalvacion = new JSONObject();
        tiradasSalvacion.put("fortaleza", 2);
        tiradasSalvacion.put("reflejos", 0);
        tiradasSalvacion.put("voluntad", 0);
        JSONObject habilidadesEscoger = new JSONObject();
        habilidadesEscoger.put("acrobacias",0);
        habilidadesEscoger.put("atletismo",0);
        habilidadesEscoger.put("historia",0);
        habilidadesEscoger.put("intimidacion",0);
        habilidadesEscoger.put("percepcion",0);
        habilidadesEscoger.put("perspicacia",0);
        habilidadesEscoger.put("supervivencia",0);
        habilidadesEscoger.put("trato con animales",0);
        Clases c = new Clases("guerrero","descripcion guerrero", tiradasSalvacion, 2, 2, habilidadesEscoger, cargarFeatures(), 10);
        listaClases.add(c);
        return listaClases;
    }

    public ArrayList<Features> cargarFeatures() {
        ArrayList<Features> listaFeatures = new ArrayList<>();
        Features f = new Features("Estilo de combate","Descripcion de Estilo de Combate",false,"CA",1) {
            public void accion(Personajes p) {
                super.accion();
                p.setCA(p.getCA()+1);
            }
        };
        listaFeatures.add(f);
        f = new Features("Nuevas Energias","Descripcion de Nuevas Energias",true,"HEAL",1) {
            public void accion(Personajes p) {
                super.accion();
                p.setVIDA(p.getVIDA()+5);
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
            public void accion(Personajes p) {
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
            public void accion(Personajes p) {
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
        ArrayList<Razas> listaRazas = new ArrayList<>();
        JSONObject puntosAtributo = new JSONObject();
        puntosAtributo.put("constitucion", 2);
        Razas r = new Razas("enano", puntosAtributo,25,"mediano", cargarEnano());
        listaRazas.add(r);
        puntosAtributo.remove("constitucion");
        puntosAtributo.put("destreza",2);
        r = new Razas("elfo",puntosAtributo,30,"mediano",cargarElfo());
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
            public void accion(Personajes p) {
                super.accion();
                JSONObject h = p.getHabilidades();
                try {
                    h.put("percepcion", 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                p.setHabilidades(h);
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
