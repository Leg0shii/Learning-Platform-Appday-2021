package de.dapole.util;

public class Leveling {

    public static int calcNextLevelEXP(int previouslevel) {
        return (int) (25 * Math.pow(2, previouslevel));
    }

    public static float timeToEXP(float ms) {
        return ms/60000;
    }

    public static int pointsToEXP(int points) {
        return points;
    }

}
