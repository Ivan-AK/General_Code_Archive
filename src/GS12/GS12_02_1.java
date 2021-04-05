package GS12;

import java.util.Comparator;
import java.util.Random;
import java.util.Map;
import java.util.TreeMap;

public class GS12_02_1 {

    public static Map<Double, String> Comparator() {
        Random rand = new Random();
        Map<Double, String> coordmap = new TreeMap<>();
        for(int i = 0; i < 10; i++) {
            Double x = (double)Math.round(rand.nextDouble() * 10 % 10 * 1000.0) / 1000.0;
            Double y = (double)Math.round(rand.nextDouble() * 10 % 10 * 1000.0) / 1000.0;
            coordmap.put((double)Math.round(Math.sqrt((x*x) + (y*y)) * 1000.0) / 1000.0, "(" + x.toString() + "," + y.toString() + ")");
        }
        return coordmap;
    }

    public static void main(String[] args) {
        System.out.println("Welcome! This program will generate 10 random points on the xy coordinate plane, then order them from closest to farthest from the origin.");
        System.out.println(Comparator());
    }
}
