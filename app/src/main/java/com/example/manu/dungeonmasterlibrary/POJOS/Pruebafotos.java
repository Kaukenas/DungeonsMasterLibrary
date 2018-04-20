package com.example.manu.dungeonmasterlibrary.POJOS;

/**
 * Created by Manu on 21/03/2018.
 */

public class Pruebafotos {
    String titulo;
    int estado, imagen;

    public Pruebafotos() {
    }

    public Pruebafotos(String titulo, int estado, int imagen) {
        this.titulo = titulo;
        this.estado = estado;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
