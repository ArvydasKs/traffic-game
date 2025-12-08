package com.example.trafficgame;

import com.example.trafficgame.model.GameWorld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTickTest {

    @Test
    public void gameTickIncreases() {
        // Given
        GameWorld world = new GameWorld();
        int before = world.getGameTicks();

        // When
        world.update();
        world.update();
        world.update();

        // Then
        int after = world.getGameTicks();
        assertEquals(before + 3, after);
    }
}
