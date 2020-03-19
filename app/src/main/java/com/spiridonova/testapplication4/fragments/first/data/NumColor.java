package com.spiridonova.testapplication4.fragments.first.data;

import java.io.Serializable;

public class NumColor implements Serializable {
    private String number;
    private int color;
    private int numberColor;

    public NumColor(String number, int color, int numberColor) {
        this.number = number;
        this.color = color;
        this.numberColor = numberColor;
    }

    public int getColor() {
        return color;
    }

    public int getNumberColor() {
        return numberColor;
    }

    public String getNumber() {
        return number;
    }
}