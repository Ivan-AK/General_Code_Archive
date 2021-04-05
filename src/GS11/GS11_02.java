package GS11;

import java.util.Scanner;

public class GS11_02 {

    public static int writeNums(int input) {
        if(input == 0) {
            return input++;
        }
        else {
            input = writeNums(input - 1) + 1;
            System.out.print(input);
            System.out.print(", ");
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! This program will take an input and give you that many numbers that start with 1s.");
        int input = console.nextInt();
        writeNums(input);
    }
}
