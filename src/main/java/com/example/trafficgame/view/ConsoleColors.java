package com.example.trafficgame.view;

public class ConsoleColors {
    private static final String reset = "\u001B[0m";
    private static final String red = "\u001B[31m";
    private static final String green = "\u001B[32m";
    private static final String yellow = "\u001B[33m";

    public static String getReset() {
        return reset;
    }

    public static String getRed() {
        return red;
    }

    public static String getGreen() {
        return green;
    }

    public static String getYellow() {
        return yellow;
    }
}
