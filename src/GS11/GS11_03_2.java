package GS11;

import java.util.Scanner;

public class GS11_03_2 {

    public static void writeSequence(double input) {
        if(input <= 0) {
            return;
        }
        else {
            if (input != (int)input) {
                System.out.print((int)input + 1);
            }
            else {
                System.out.print((int)input);
            }
            writeSequence(input - 1);
            if(input != 0.5) {
                if (input != (int)input) {
                    System.out.print((int)input + 1);
                }
                else {
                    System.out.print((int)input);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! This program will take an input, and write out a sequence.");
        System.out.print("Please enter a number that is to be the length of the sequence: ");
        double input = console.nextDouble();
        writeSequence((input) / 2);
    }
}