package com.example.manu.dungeonmasterlibrary.POJOS;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Manu on 11/05/2018.
 */

public class Objetos implements Parcelable {

    private String nombreArma;
    private int id;
    private int caras;
    private int numDados;
    private String tipo;

    public Objetos() {
    }

    public Objetos(String nombreArma, int id, int caras, int numDados, String tipo) {
        this.nombreArma = nombreArma;
        this.id = id;
        this.caras = caras;
        this.numDados = numDados;
        this.tipo = tipo;
    }

    protected Objetos(Parcel in) {
        nombreArma = in.readString();
        id = in.readInt();
        caras = in.readInt();
        numDados = in.readInt();
        tipo = in.readString();
    }

    public static final Creator<Objetos> CREATOR = new Creator<Objetos>() {
        @Override
        public Objetos createFromParcel(Parcel in) {
            return new Objetos(in);
        }

        @Override
        public Objetos[] newArray(int size) {
            return new Objetos[size];
        }
    };

    public String getNombreArma() {
        return nombreArma;
    }

    public void setNombreArma(String nombreArma) {
        this.nombreArma = nombreArma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaras() {
        return caras;
    }

    public void setCaras(int caras) {
        this.caras = caras;
    }

    public int getNumDados() {
        return numDados;
    }

    public void setNumDados(int numDados) {
        this.numDados = numDados;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombreArma);
        parcel.writeInt(id);
        parcel.writeInt(caras);
        parcel.writeInt(numDados);
        parcel.writeString(tipo);
    }
}
