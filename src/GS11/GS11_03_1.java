package GS11;

import java.util.Scanner;

public class GS11_03_1 {

    public static void writeSequence(int input) {
        if(input < 1) {
           return;
        }
        else {
            System.out.print(input - input / 2);
            writeSequence(input - 2);
            if(input != 1) {
                System.out.print(input - input / 2);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! This program will take an input, and write out a sequence.");
        System.out.print("Please enter a number that is to be the length of the sequence: ");
        int input = console.nextInt();
        writeSequence(input);
    }
}
