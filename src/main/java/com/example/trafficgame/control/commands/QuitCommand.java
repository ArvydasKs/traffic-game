package com.example.trafficgame.control.commands;

import com.example.trafficgame.control.GameController;

public class QuitCommand implements Command {
    private final GameController controller;

    public QuitCommand(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.stopRunning();
    }
}
