package com.example.trafficgame;

import com.example.trafficgame.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollisionTest {

    @Test
    public void collisionHappensWhenTwoLanesMove() {
        // Given
        GameWorld world = new GameWorld();
        Lane lane1 = world.getLanes().get(0);
        Lane lane2 = world.getLanes().get(1);

        lane1.addCar(new NormalCar(Direction.NORTH));
        lane2.addCar(new EmergencyCar(Direction.SOUTH));

        // When
        lane1.getTrafficLight().forceColorForTest(LightColor.GREEN);
        lane2.getTrafficLight().forceColorForTest(LightColor.GREEN);
        world.checkGameOver();

        // Then
        assertEquals(GameOverReason.COLLISION, world.getGameOverReason());
    }
}
