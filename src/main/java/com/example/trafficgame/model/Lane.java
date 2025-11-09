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
        this.trafficLight = new SimpleTrafficLight();
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
        if (trafficLight.getColor() == LightColor.GREEN && !cars.isEmpty()) {
            cars.poll();
        }
    }
}
