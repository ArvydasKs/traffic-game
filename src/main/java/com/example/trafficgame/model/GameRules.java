package com.example.trafficgame.model;

public class GameRules {
    private static final int numberOfLanes = 2; // turi buti tarp 2 ir 4 keliu
    private static final int maxCars = 5; // kiek masinu gali buti spustyje
    private static final int winTicks = 30; // kiek ciklu, kad laimeti
    private static final double spawnProbability = 0.4; // sansas, kad atsiras automobilis
    private static final double emergencyCarProbability = 0.2; // sansas, kad atsirades automobilis bus avarinis
    private static final int gameSpeedMs = 1000; // kas kiek ms keiciasi ciklai
    private static final boolean useSimpleTrafficLights = true; // naudoti sviesoforus, kurie turi tik dvi fazes vietoj triju

    public static int getNumberOfLanes() { return numberOfLanes; }
    public static int getMaxCars() { return maxCars; }
    public static int getWinTicks() { return winTicks; }
    public static double getSpawnProbability() { return spawnProbability; }
    public static double getEmergencyCarProbability() { return emergencyCarProbability; }
    public static int getGameSpeedMs() { return gameSpeedMs; }
    public static boolean getUseSimpleTrafficLights() { return useSimpleTrafficLights; }

}

