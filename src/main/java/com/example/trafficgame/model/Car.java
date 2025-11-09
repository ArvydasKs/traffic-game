package com.example.trafficgame.model;

public class Car {
    private final Direction direction;

    public Car(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return switch (direction) {
            case NORTH -> "↑";
            case SOUTH -> "↓";
            case EAST -> "→";
            case WEST -> "←";
        };
    }
}
