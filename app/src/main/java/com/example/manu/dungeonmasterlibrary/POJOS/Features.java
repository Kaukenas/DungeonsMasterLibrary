package com.example.manu.dungeonmasterlibrary.POJOS;

/**
 * Created by Manu on 20/04/2018.
 */

public abstract class Features {
    private String nombre;
    private String descripcion;
    private boolean usoUnico;
    private String keyword;
    private int requisitoNivel;

    public Features() {
    }

    public Features(String nombre, String descripcion, boolean usoUnico, String keyword, int requisitoNivel) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usoUnico = usoUnico;
        this.keyword = keyword;
        this.requisitoNivel = requisitoNivel;
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

    public boolean isUsoUnico() {
        return usoUnico;
    }

    public void setUsoUnico(boolean usoUnico) {
        this.usoUnico = usoUnico;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getRequisitoNivel() {
        return requisitoNivel;
    }

    public void setRequisitoNivel(int requisitoNivel) {
        this.requisitoNivel = requisitoNivel;
    }

    public void accion(){

    }
}
