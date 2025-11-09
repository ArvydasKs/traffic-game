package com.example.trafficgame.model;

public class GameRules {
    public static int numberOfLanes = 2; // turi buti tarp 2 ir 4 keliu
    public static final int maxCars = 5; // kiek masinu gali buti spustyje
    public static final int winTicks = 30; // kiek ciklu, kad laimeti
    public static final double spawnProbability = 0.3; // sansas, kad atsiras automobilis
    public static final int gameSpeedMs = 1000; // kas kiek ms keiciasi ciklai
}
