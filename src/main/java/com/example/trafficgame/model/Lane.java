package com.example.trafficgame.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lane {
    private final Direction direction;
    private final TrafficLight trafficLight;
    private final Queue<Car> cars = new LinkedList<>();

    public Lane(Direction direction) {
        this.direction = direction;
        this.trafficLight = TrafficLightFactory.create(GameRules.getUseSimpleTrafficLights());
    }

    public Direction getDirection() {
        return direction;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public int getQueueSize() {
        return cars.size();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void update() {
        if (cars.isEmpty()) return;

        Car frontCar = cars.peek();

        if (frontCar.canMoveOn(trafficLight.getColor())) {
            cars.poll();
        }
    }

    public boolean willMoveThisTick() {
        if (cars.isEmpty()) return false;

        Car frontCar = cars.peek();

        return frontCar.canMoveOn(trafficLight.getColor());
    }
}
