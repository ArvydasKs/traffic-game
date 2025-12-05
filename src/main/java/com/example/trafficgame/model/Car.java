package com.example.trafficgame.model;

public abstract class Car {
    private final Direction direction;

    protected Car(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public abstract String toString();
}
