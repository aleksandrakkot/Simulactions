package com.company;

import com.company.vector.Vector2D;

import java.util.Random;

public class Utils {

    static final int WIDTH = 50;
    static final int HEIGHT = 50;
    static final int SCALE = 10;

    public static Vector2D generateVector() {

        int x = Utils.getRandomNumber(1, 10);
        x= x<6 ? -1 : 1;
        int y = Utils.getRandomNumber(1, 10);
        y= y<6 ? -1 : 1;
        return new Vector2D(x, y);
    }

    public static double generateVelocity() {
        Random random = new Random();
        return (0.1 + 2.4 * random.nextDouble()) / 25 * Utils.SCALE;
    }

    public static double[] generateStartCords(int width, int height) {
        int random = Utils.getRandomNumber(1, 4);
        int x = 0, y = 0;

        switch (random) {
            case 1 -> {
                y = Utils.getRandomNumber(10, height - 10);
                x = 10;
            }
            case 2 -> {
                x = width - 10;
                y = Utils.getRandomNumber(10, height - 10);
            }
            case 3 -> {
                x = Utils.getRandomNumber(10, width - 10);
                y = 10;
            }
            case 4 -> {
                y = height - 10;
                x = Utils.getRandomNumber(10, width - 10);
            }
        }
        return new double[]{x, y};
    }

    public static boolean isLeaving() {
        return Utils.getRandomNumber(1, 10) < 5;
    }

    public static int getRandomNumber(int from, int to) {
        Random random = new Random();
        return (random.nextInt((to - from) + 1) + from);
    }

    public static boolean isOutOfBounds(double value, int max) {
        return value > max;
    }

    public static double getDistance(double[] first, double[] second) {
        return Math.sqrt(Math.pow(second[0] - first[0], 2) + Math.pow(second[1] - first[1], 2));
    }

}
