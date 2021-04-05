package GS12;

import java.util.*;

public class GS12_02_2 {

    public static class distanceComparator implements Comparator<Double> {
        public int compare(Double p1, Double p2) {
            return (int) ((p1 * 1000) - (p2 * 1000));
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Double> points = new ArrayList<>();
        System.out.println("Welcome! This program will generate 10 random points on the xy coordinate plane, then order them from closest to farthest from the origin.");

        for (int i = 0; i < 10; i++) {
            Double x = (double) Math.round(rand.nextDouble() * 10 % 10 * 1000.0) / 1000.0;
            Double y = (double) Math.round(rand.nextDouble() * 10 % 10 * 1000.0) / 1000.0;
            points.add((double) Math.round(Math.sqrt((x * x) + (y * y)) * 1000.0) / 1000.0);
        }
        System.out.println(points);

        Collections.sort(points, new distanceComparator());

        System.out.println(points);
    }
}

