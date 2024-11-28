package com.example.pokerecycler;

public class Pokemon {
    private String name;
    private int imageUrl;

    public Pokemon(String name, int imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}
