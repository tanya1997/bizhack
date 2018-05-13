package com.example.empyrean.bizhackdaytwo.adapters;

public class Lot {
    String title;
    String description;
    String cost;
    int imageResourceId;

    public Lot(String title, String description, String cost, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.imageResourceId = imageResourceId;
    }
}
