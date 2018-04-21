package com.example.manu.dungeonmasterlibrary.POJOS;

import android.media.Image;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Manu on 20/04/2018.
 */

public class Personajes {
    private String nombre;
    private int CA;
    private int VIDA;
    private int DAMAGE;
    private Image fotoPersonaje;
    private JSONObject atributos;
    private String alineamiento;
    private JSONObject habilidades;
    private Clases clases;
    private Razas razas;
    private int idUsuario;

    public Personajes() {
    }

    public Personajes(String nombre, Image fotoPersonaje, JSONObject atributos, String alineamiento, JSONObject habilidades, Clases clases, Razas razas, int idUsuario) {
        this.nombre = nombre;
        this.fotoPersonaje = fotoPersonaje;
        this.atributos = atributos;
        this.alineamiento = alineamiento;
        this.habilidades = habilidades;
        this.clases = clases;
        this.razas = razas;
        this.idUsuario = idUsuario;
    }

    public int getDAMAGE() {
        return DAMAGE;
    }

    public void setDAMAGE(int DAMAGE) {
        this.DAMAGE = DAMAGE;
    }

    public int getVIDA() {
        return VIDA;
    }

    public void setVIDA(int VIDA) {
        this.VIDA = VIDA;
    }

    public int getCA() {
        return CA;
    }

    public void setCA(int CA) {
        this.CA = CA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getFotoPersonaje() {
        return fotoPersonaje;
    }

    public void setFotoPersonaje(Image fotoPersonaje) {
        this.fotoPersonaje = fotoPersonaje;
    }

    public JSONObject getAtributos() {
        return atributos;
    }

    public void setAtributos(JSONObject atributos) {
        this.atributos = atributos;
    }

    public String getAlineamiento() {
        return alineamiento;
    }

    public void setAlineamiento(String alineamiento) {
        this.alineamiento = alineamiento;
    }

    public JSONObject getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(JSONObject habilidades) {
        this.habilidades = habilidades;
    }

    public Clases getClases() {
        return clases;
    }

    public void setClases(Clases clases) {
        this.clases = clases;
    }

    public Razas getRazas() {
        return razas;
    }

    public void setRazas(Razas razas) {
        this.razas = razas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
