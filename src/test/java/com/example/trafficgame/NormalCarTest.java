package com.example.trafficgame;

import com.example.trafficgame.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalCarTest {

    @Test
    public void normalCarMovesOnlyOnGreen() {
        // Given
        Lane lane = new Lane(Direction.NORTH);
        Car car = new NormalCar(Direction.NORTH);
        lane.addCar(car);

        // When 1
        lane.getTrafficLight().forceColorForTest(LightColor.RED);
        lane.update();

        // Then 1
        assertEquals(1, lane.getQueueSize());

        // When 2
        lane.getTrafficLight().forceColorForTest(LightColor.YELLOW);
        lane.update();

        // Then 2
        assertEquals(1, lane.getQueueSize());

        // When 3
        lane.getTrafficLight().forceColorForTest(LightColor.GREEN);
        lane.update();

        // Then 3
        assertEquals(0, lane.getQueueSize());
    }
}
