package com.example.trafficgame.control;

import com.example.trafficgame.model.Direction;
import com.example.trafficgame.model.GameRules;
import com.example.trafficgame.model.GameWorld;
import com.example.trafficgame.view.ConsoleColors;
import com.example.trafficgame.view.GameRenderer;

import java.util.Scanner;

public class GameController {
    private final GameWorld world;
    private final GameRenderer renderer;
    private final Scanner scanner = new Scanner(System.in);
    private volatile boolean running = true;

    public GameController(GameWorld world, GameRenderer renderer) {
        this.world = world;
        this.renderer = renderer;
    }

    public void start() {
        Thread inputThread = new Thread(this::listenForInput);
        inputThread.start();

        while (!world.isGameOver() && running) {
            world.update();
            renderer.render(world);

            try {
                Thread.sleep(GameRules.gameSpeedMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        running = false;
        showGameOver();
    }

    private void listenForInput() {
        while (running && !world.isGameOver()) {
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Q")) {
                running = false;
                break;
            }

            processInput(input);
        }
    }

    private void processInput(String input) {
        try {
            int laneIndex = Integer.parseInt(input) - 1;

            if (laneIndex >= 0 && laneIndex < world.getLanes().size()) {
                Direction direction = world.getLanes().get(laneIndex).getDirection();
                world.changeLight(direction);
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input!");
        }
    }

    private void showGameOver() {
        System.out.println("\nGAME OVER");

        switch (world.getGameOverReason()) {
            case WIN -> System.out.println(ConsoleColors.GREEN + "You won! You survived all cycles!" + ConsoleColors.RESET);
            case COLLISION -> System.out.println(ConsoleColors.RED + "You lost! A collision happened!" + ConsoleColors.RESET);
            case TRAFFIC_JAM -> System.out.println(ConsoleColors.RED + "You lost! A traffic jam happened!" + ConsoleColors.RESET);
        }

        System.out.println("Cycles survived: " + world.getGameTicks());
    }
}
