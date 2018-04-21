package com.example.manu.dungeonmasterlibrary.POJOS;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Manu on 20/04/2018.
 */

public class Razas implements Parcelable {
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

    protected Razas(Parcel in) {
        name = in.readString();
        velocidad = in.readInt();
        tamaño = in.readString();
    }

    public static final Creator<Razas> CREATOR = new Creator<Razas>() {
        @Override
        public Razas createFromParcel(Parcel in) {
            return new Razas(in);
        }

        @Override
        public Razas[] newArray(int size) {
            return new Razas[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(velocidad);
        parcel.writeString(tamaño);
    }
}
