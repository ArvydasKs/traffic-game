package com.example.trafficgame.model;

public class TrafficLightFactory {

    public static TrafficLight create(boolean simple) {
        if (simple) {
            return new SimpleTrafficLight();
        } else {
            return new RegularTrafficLight();
        }
    }
}
