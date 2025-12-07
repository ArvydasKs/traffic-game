package com.example.trafficgame.model;

public abstract class TrafficLight {
    private LightColor color = LightColor.RED;

    public LightColor getColor() {
        return color;
    }

    protected void setColor(LightColor color) {
        this.color = color;
    }

    public void forceColorForTest(LightColor color) {
        this.color = color;
    }

    public abstract void nextPhase();
}
