package org.example;

import jdk.jfr.Description;

public class Tablet extends TouchScreen{
    private final float cashbackCoef = 0.003f;

    public Tablet(String trademark, String model, float price, int ram, float diagonal, int battery, float weight) {
        super(trademark, model, price, ram, diagonal, battery, weight);
    }

    @Override
    public float getCashback() {
        return price*cashbackCoef;
    }

    @Override
    public void description() {
        super.description();
        System.out.println();
    }
}
