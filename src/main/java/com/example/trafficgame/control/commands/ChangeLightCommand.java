package com.example.trafficgame.control.commands;

import com.example.trafficgame.model.Direction;
import com.example.trafficgame.model.GameWorld;
import com.example.trafficgame.model.Lane;

public class ChangeLightCommand implements Command {
    private final GameWorld world;
    private final int laneIndex;

    public ChangeLightCommand(GameWorld world, int laneIndex) {
        this.world = world;
        this.laneIndex = laneIndex;
    }

    @Override
    public void execute() {
        if (laneIndex < 0 || laneIndex >=world.getLanes().size()) {
            System.out.println("This lane doesn't exist!");
            return;
        }

        Lane lane = world.getLanes().get(laneIndex);
        Direction direction = lane.getDirection();
        world.changeLight(direction);
    }
}
