package GS14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GS14_01 {

    public static int minimum(int a, int b, int c) {
        return Integer.min(a, Integer.min(b, c));
    }

    public static int dist(String X, int m, String Y, int n)
    {
        // base case: empty strings (case 1)
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        // if the last characters of the strings match (case 2)
        int cost = (X.charAt(m - 1) == Y.charAt(n - 1)) ? 0: 1;
        return minimum(dist(X, m - 1, Y, n) + 1, // deletion (case 3a))
                dist(X, m, Y, n - 1) + 1, // insertion (case 3b))
                dist(X, m - 1, Y, n - 1) + cost); // substitution (case 2 & 3c)
    }

    public static LinkedList FindNeighbors(String base_word) throws FileNotFoundException {
        LinkedList<String> neighbors = new LinkedList<>();
        Scanner fr = new Scanner(new File("Levenshtein_Test_Dictionary.txt"));
        while(fr.hasNextLine()) {
            String temp = fr.nextLine();
            if(temp.compareTo(base_word) != 0 && dist(base_word, base_word.length(), temp, temp.length()) == 1) {
                neighbors.add(temp);
            }
        }
        return neighbors;
    }

    public static int pathfinder(String base_word, String target) throws FileNotFoundException {
        LinkedList<String> neighbors = new LinkedList<>();
        neighbors.addAll(FindNeighbors(base_word));
        if(base_word.compareTo(target) == 0) {
            return 0;
        }
        else if(neighbors.isEmpty()) {
            return 0;
        }
        else if(neighbors.contains(target)) {
            return 1;
        }
        base_word = neighbors.removeFirst();
        return 1 + pathfinder(base_word, target);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! This program will use a custom definition of the Levenstein Distance between two words.");
        System.out.println("The number outputted by this program will be how many transformations the given word needs to make, through other words, to get to the target word.");
        System.out.print("\nPlease input the first word here ---> ");
        String base_word = console.nextLine();
        System.out.print("\nPlease input the second word here ---> ");
        String target = console.nextLine();

        System.out.println("\n\nThe distance between these two words is: " + pathfinder(base_word, target));
    }
}