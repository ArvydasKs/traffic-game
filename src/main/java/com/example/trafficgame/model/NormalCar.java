package com.example.trafficgame.model;

public class NormalCar extends Car {
    public NormalCar(Direction direction) {
        super(direction);
    }

    @Override
    public String toString() {
        return switch (getDirection()) {
            case NORTH -> "↑";
            case SOUTH -> "↓";
            case EAST -> "→";
            case WEST -> "←";
        };
    }
}
