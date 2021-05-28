package de.dapole.util;

public class Leveling {

    public static int calcNextLevelEXP(int previouslevel) {
        return previouslevel*2 + 100;
    }

    public static float timeToEXP(float ms) {
        return ms/60000;
    }

    public static int pointsToEXP(int points) {
        return points;
    }

}
