package com.example.proyectosqlite.Model;

public class Planet {

    private String name;
    private int diametro;
    private int gravedad;

    public Planet(String name, int diametro, int gravedad) {
        this.name = name;
        this.diametro = diametro;
        this.gravedad = gravedad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }
}
