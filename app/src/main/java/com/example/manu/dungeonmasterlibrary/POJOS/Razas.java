package com.example.manu.dungeonmasterlibrary.POJOS;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Manu on 20/04/2018.
 */

public class Razas {
    private String name;
    private JSONObject puntosAtributos;
    private int velocidad;
    private String tamaño;
    private ArrayList<Traits> razas;

    public Razas() {
    }

    public Razas(String name, JSONObject puntosAtributos, int velocidad, String tamaño, ArrayList<Traits> razas) {
        this.name = name;
        this.puntosAtributos = puntosAtributos;
        this.velocidad = velocidad;
        this.tamaño = tamaño;
        this.razas = razas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONObject getPuntosAtributos() {
        return puntosAtributos;
    }

    public void setPuntosAtributos(JSONObject puntosAtributos) {
        this.puntosAtributos = puntosAtributos;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public ArrayList<Traits> getRazas() {
        return razas;
    }

    public void setRazas(ArrayList<Traits> razas) {
        this.razas = razas;
    }
}
