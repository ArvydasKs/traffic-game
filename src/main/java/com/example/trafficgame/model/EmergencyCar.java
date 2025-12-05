package com.example.trafficgame.model;

public class EmergencyCar extends Car {
    public EmergencyCar(Direction direction) {
        super(direction);
    }

    @Override
    public String toString() {
        return "✚";
    }
}
