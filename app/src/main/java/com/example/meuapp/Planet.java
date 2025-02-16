package com.example.meuapp;

public class Planet {
    private String name;
    private int imageResource;

    public Planet(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}
