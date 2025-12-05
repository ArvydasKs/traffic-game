package com.example.trafficgame.model;

import java.util.Random;

public class CarFactory {
    private static final Random random = new Random();

    public static Car create(Direction direction) {
        if (random.nextDouble() < GameRules.getEmergencyCarProbability()) {
            return new EmergencyCar(direction);
        } else {
            return new NormalCar(direction);
        }
    }
}
