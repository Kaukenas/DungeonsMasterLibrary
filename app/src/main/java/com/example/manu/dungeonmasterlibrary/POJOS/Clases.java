package com.example.manu.dungeonmasterlibrary.POJOS;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Manu on 20/04/2018.
 */

public class Clases {

    private String nombre;
    private String descripcion;
    private JSONObject tiradasSalvacion;
    private int numHabilidades;
    private int bonoDeCompetencia;
    private JSONObject habilidadesEscoger;
    private ArrayList<Features> clases;
    private int dadoGolpe;

    public Clases() {
    }

    public Clases(String nombre, String descripcion, JSONObject tiradasSalvacion, int numHabilidades, int bonoDeCompetencia, JSONObject habilidadesEscoger, ArrayList<Features> clases, int dadoGolpe) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiradasSalvacion = tiradasSalvacion;
        this.numHabilidades = numHabilidades;
        this.bonoDeCompetencia = bonoDeCompetencia;
        this.habilidadesEscoger = habilidadesEscoger;
        this.clases = clases;
        this.dadoGolpe = dadoGolpe;
    }

    public int getDadoGolpe() {
        return dadoGolpe;
    }

    public void setDadoGolpe(int dadoGolpe) {
        this.dadoGolpe = dadoGolpe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public JSONObject getTiradasSalvacion() {
        return tiradasSalvacion;
    }

    public void setTiradasSalvacion(JSONObject tiradasSalvacion) {
        this.tiradasSalvacion = tiradasSalvacion;
    }

    public int getNumHabilidades() {
        return numHabilidades;
    }

    public void setNumHabilidades(int numHabilidades) {
        this.numHabilidades = numHabilidades;
    }

    public int getBonoDeCompetencia() {
        return bonoDeCompetencia;
    }

    public void setBonoDeCompetencia(int bonoDeCompetencia) {
        this.bonoDeCompetencia = bonoDeCompetencia;
    }

    public JSONObject getHabilidadesEscoger() {
        return habilidadesEscoger;
    }

    public void setHabilidadesEscoger(JSONObject habilidadesEscoger) {
        this.habilidadesEscoger = habilidadesEscoger;
    }

    public ArrayList<Features> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Features> clases) {
        this.clases = clases;
    }
}
