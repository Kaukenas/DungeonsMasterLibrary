package com.example.manu.dungeonmasterlibrary.POJOS;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Manu on 20/04/2018.
 */

public class Clases implements Parcelable {

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

    protected Clases(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        numHabilidades = in.readInt();
        bonoDeCompetencia = in.readInt();
        dadoGolpe = in.readInt();
        try {
            habilidadesEscoger = new JSONObject(in.readString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final Creator<Clases> CREATOR = new Creator<Clases>() {
        @Override
        public Clases createFromParcel(Parcel in) {
            return new Clases(in);
        }

        @Override
        public Clases[] newArray(int size) {
            return new Clases[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(descripcion);
        parcel.writeInt(numHabilidades);
        parcel.writeInt(bonoDeCompetencia);
        parcel.writeInt(dadoGolpe);
        parcel.writeString(habilidadesEscoger.toString());
    }
}
