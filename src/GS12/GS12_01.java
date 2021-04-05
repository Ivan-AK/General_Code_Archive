package GS12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class GS12_01 {

    static public void main(String[] args) throws FileNotFoundException {
        ArrayList<String> dictionary = new ArrayList<>();
        Scanner fr = new Scanner(new File("dictionary.txt"));
        while(fr.hasNextLine()) {
            dictionary.add(fr.nextLine());
        }
        Scanner console = new Scanner(System.in);
        System.out.print("Welcome! This program will find the distance between two words in a dictionary.\nPlease input the first word here ---> ");
        String input_1 = console.nextLine();
        System.out.print("\nPlease input the second word here ---> ");
        String input_2 = console.nextLine();
        int distance = Math.abs(Collections.binarySearch(dictionary, input_1) - Collections.binarySearch(dictionary, input_2)) - 1;
        System.out.println("\n\nThere are " + distance + " words between the first and seconds inputs.");
    }
}
