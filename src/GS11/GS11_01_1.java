package GS11;

import java.util.Scanner;

public class GS11_01_1 {

    public static void starString(int input) {
        if(input == 0) {
            return;
        }
        else {
            starString(input - 1);
            System.out.print("*");
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int star_number = 1;
        System.out.println("Welcome! This program will print 2 to the power of your input of stars.");
        int input = console.nextInt();
        for(int i = 0; i < input; i++) {
            star_number = star_number * 2;
        }
        starString(star_number);
    }
}
