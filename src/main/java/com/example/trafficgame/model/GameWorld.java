package com.example.trafficgame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameWorld {
    private final List<Lane> lanes = new ArrayList<>();

    private final Random random = new Random();
    private boolean gameOver = false;
    private int gameTicks = 0;
    private GameOverReason gameOverReason = GameOverReason.NONE;

    public GameWorld() {
        Direction[] directions = Direction.values();
        for (int i = 0; i < GameRules.getNumberOfLanes(); i++) {
            lanes.add(new Lane(directions[i]));
        }
    }

    public List<Lane> getLanes() {
        return new ArrayList<>(lanes);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getGameTicks() {
        return gameTicks;
    }

    public GameOverReason getGameOverReason() {
        return gameOverReason;
    }

    public void update() {
        gameTicks++;
        for (Lane lane : lanes) {
            lane.update();
        }

        spawnCars();
        checkGameOver();
    }

    private void spawnCars() {
        for (Lane lane : lanes) {
            if (random.nextDouble() < GameRules.getSpawnProbability()) {
                Car car = CarFactory.create(lane.getDirection());
                lane.addCar(car);
            }
        }
    }

    private boolean checkCollision() {
        int activeLanes = 0;

        for (Lane lane : lanes) {
            if (lane.willMoveThisTick()) {
                activeLanes++;
            }
        }

        return activeLanes > 1;
    }

    public void changeLight(Direction direction) {
        for (Lane lane : lanes) {
            if (lane.getDirection() == direction) {
                lane.getTrafficLight().nextPhase();
                break;
            }
        }
    }

    public void checkGameOver() {
        for (Lane lane : lanes) {
            if (lane.getQueueSize() > GameRules.getMaxCars()) {
                gameOverReason = GameOverReason.TRAFFIC_JAM;
                gameOver = true;
                return;
            }
        }

        if (checkCollision()) {
            gameOverReason = GameOverReason.COLLISION;
            gameOver = true;
            return;
        }

        if (gameTicks >= GameRules.getWinTicks()) {
            gameOverReason = GameOverReason.WIN;
            gameOver = true;
        }
    }
}
