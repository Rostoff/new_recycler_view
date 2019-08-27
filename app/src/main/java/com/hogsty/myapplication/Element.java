package com.hogsty.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Element {
    private String name;
    private String description;
    private int image;
    private int arrow;

    public Element(String name, String description, int image, int arrow) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.arrow = arrow;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public int getArrow() {
        return arrow;
    }
}
