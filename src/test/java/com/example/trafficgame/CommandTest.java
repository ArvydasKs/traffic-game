package com.example.trafficgame;

import com.example.trafficgame.control.GameController;
import com.example.trafficgame.control.commands.Command;
import com.example.trafficgame.model.*;
import com.example.trafficgame.view.GameRenderer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {

    @Test
    public void validNumberChangesTrafficLight() {
        // Given
        GameWorld world = new GameWorld();
        GameRenderer renderer = new GameRenderer();
        GameController controller = new GameController(world, renderer);

        Lane lane = world.getLanes().getFirst();
        LightColor before = lane.getTrafficLight().getColor();

        // When
        Command cmd = controller.createCommand("1");
        cmd.execute();

        // Then
        LightColor after = lane.getTrafficLight().getColor();
        assertNotEquals(before, after);
    }

    @Test
    public void outOfRangeNumberDoesNothing() {
        // Given
        GameWorld world = new GameWorld();
        GameRenderer renderer = new GameRenderer();
        GameController controller = new GameController(world, renderer);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        // When
        String invalidInput = String.valueOf(world.getLanes().size() + 1);
        Command cmd = controller.createCommand(invalidInput);
        cmd.execute();

        System.setOut(originalOut);

        // Then
        String consoleOutput = out.toString().trim();
        assertEquals("This lane doesn't exist!", consoleOutput);
    }

    @Test
    public void invalidInputDoesNothing() {
        // Given
        GameWorld world = new GameWorld();
        GameRenderer renderer = new GameRenderer();
        GameController controller = new GameController(world, renderer);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        // When
        Command cmd = controller.createCommand("test");
        cmd.execute();

        System.setOut(originalOut);

        // Then
        String consoleOutput = out.toString().trim();
        assertEquals("Wrong input!", consoleOutput);
    }

    @Test
    public void qQuitsTheGame() {
        // Given
        GameWorld world = new GameWorld();
        GameRenderer renderer = new GameRenderer();
        GameController controller = new GameController(world, renderer);

        // When
        Command cmd = controller.createCommand("q");
        cmd.execute();

        // Then
        assertFalse(controller.isRunning());
    }
}
