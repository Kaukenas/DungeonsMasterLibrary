package com.example.manu.dungeonmasterlibrary.POJOS;

/**
 * Created by Manu on 20/04/2018.
 */

public abstract class Traits {
    private String nombre;
    private String descripcion;

    public Traits() {
    }

    public Traits(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public void accion(){

    }
}
