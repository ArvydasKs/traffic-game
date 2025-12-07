package com.example.trafficgame;

import com.example.trafficgame.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficJamTest {

    @Test
    public void trafficJamHappensWhenTooManyCarsInLane() {
        // Given
        GameWorld world = new GameWorld();
        Lane lane = world.getLanes().getFirst();

        for (int i = 0; i < GameRules.getMaxCars() + 1; i++) {
            lane.addCar(new NormalCar(Direction.NORTH));
        }

        // When
        world.checkGameOver();

        // Then
        assertEquals(GameOverReason.TRAFFIC_JAM, world.getGameOverReason());
    }
}
