package com.example.trafficgame;

import com.example.trafficgame.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmergencyCarTest {

    @Test
    public void emergencyCarMovesAlways() {
        // Given
        Lane lane = new Lane(Direction.NORTH);

        lane.addCar(new EmergencyCar(Direction.NORTH));
        lane.addCar(new EmergencyCar(Direction.NORTH));
        lane.addCar(new EmergencyCar(Direction.NORTH));

        // When 1
        lane.getTrafficLight().forceColorForTest(LightColor.RED);
        lane.update();

        // Then 1
        assertEquals(2, lane.getQueueSize());

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
