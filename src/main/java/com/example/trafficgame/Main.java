package com.example.trafficgame;

import com.example.trafficgame.control.GameController;
import com.example.trafficgame.model.GameRules;
import com.example.trafficgame.model.GameWorld;
import com.example.trafficgame.view.GameRenderer;

public class Main {
    public static void main(String[] args) {
        if (GameRules.numberOfLanes < 2 || GameRules.numberOfLanes > 4) {
            System.out.println("The number of lanes must be between 2 and 4");
            return;
        }

        GameWorld world = new GameWorld();
        GameRenderer renderer = new GameRenderer();
        GameController controller = new GameController(world, renderer);

        controller.start();
    }
}
