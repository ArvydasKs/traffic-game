package com.example.trafficgame.model;

public class EmergencyCar extends Car {
    public EmergencyCar(Direction direction) {
        super(direction);
    }

    @Override
    public boolean canMoveOn(LightColor lightColor) {
        return true;
    }

    @Override
    public String toString() {
        return "✚";
    }
}
