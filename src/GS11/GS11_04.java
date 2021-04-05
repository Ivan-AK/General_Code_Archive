package GS11;

import java.util.Scanner;

public class GS11_04 {

    public static float sumTo(float input) {
        if(input == 0) {
            return 0;
        }
        else {
            return (1 / input) + sumTo(input - 1);
        }
    }

    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! This program will take an input and return a sum.");
        System.out.print("Enter number here ---> ");
        float input = console.nextFloat();
        System.out.println(sumTo(input));
    }
}
