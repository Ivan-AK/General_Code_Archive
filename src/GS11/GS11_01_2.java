package GS11;

import java.util.Scanner;

public class GS11_01_2 {

    public static void starString(int input) {
        if(input <= 0) {
            System.out.print("*");
            return;
        }
        else {
            starString(input - 1);
            starString(input - 1);
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! This program will print 2 to the power of your input of stars.");
        int input = console.nextInt();
        starString(input);
    }
}
