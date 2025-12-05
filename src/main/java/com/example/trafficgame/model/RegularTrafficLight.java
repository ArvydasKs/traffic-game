package com.example.trafficgame.model;

public class RegularTrafficLight extends TrafficLight {
    @Override
    public void nextPhase() {
        switch (getColor()) {
            case RED -> setColor(LightColor.GREEN);
            case GREEN -> setColor(LightColor.YELLOW);
            case YELLOW -> setColor(LightColor.RED);
        }
    }
}
