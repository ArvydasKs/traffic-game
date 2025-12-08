package com.example.trafficgame.view;

import com.example.trafficgame.model.Car;
import com.example.trafficgame.model.GameWorld;
import com.example.trafficgame.model.Lane;
import com.example.trafficgame.model.LightColor;

public class GameRenderer {
    public void render(GameWorld world) {
        clearConsole();

        System.out.println("Traffic Game");
        System.out.println("Cycle: " + world.getGameTicks());
        System.out.println();

        int index = 1;
        for (Lane lane : world.getLanes()) {
            StringBuilder line = new StringBuilder();
            line.append("[").append(index++).append("] ");
            line.append(String.format("%-6s: ", lane.getDirection()));

            for (Car car : lane.getCars()) {
                line.append(car);
            }

            line.append(" | ").append(colorString(lane.getTrafficLight().getColor()));
            System.out.println(line);
        }

        System.out.println();
        System.out.println("Control traffic lights (1-" + world.getLanes().size() + ") or q to quit\n");
    }

    private String colorString(LightColor color) {
        return switch (color) {
            case RED -> ConsoleColors.getRed() + "RED" + ConsoleColors.getReset();
            case GREEN -> ConsoleColors.getGreen() + "GREEN" + ConsoleColors.getReset();
            case YELLOW -> ConsoleColors.getYellow() + "YELLOW" + ConsoleColors.getReset();
        };
    }

    private void clearConsole() {
        for (int i = 0; i < 25; i++) System.out.println();
    }
}
