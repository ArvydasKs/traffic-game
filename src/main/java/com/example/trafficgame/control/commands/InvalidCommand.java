package com.example.trafficgame.control.commands;

public class InvalidCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Wrong input!");
    }
}
