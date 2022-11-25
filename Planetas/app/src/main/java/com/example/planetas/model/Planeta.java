package com.example.planetas.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class Planeta {
    @SerializedName("name")
    private String name;
    @SerializedName("distance")
    private Integer distance;
    @SerializedName("gravity")
    private int gravity;
    @SerializedName("diameter")
    private int diameter;
    @SerializedName("image")
    private String imagePath;

    private Bitmap foto;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }
}
