package GS10;

import java.util.Scanner;

class GS10_01
{
    static int fibonacci(int input)
    {
        if (input <= 1) {
            return input;
        }
        return fibonacci(input-1) + fibonacci(input-2);
    }

    public static void main (String args[]) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! This program uses a recursive method to find fibonacci numbers.");
        System.out.println("Input a number, and the program will return that fibonacci number. Example: inputting a 3 will retrieve the 3rd fibonacci number, which is 2.");
        System.out.print("Enter number here ---> ");
        int input = console.nextInt();
        System.out.println("\n\t" + fibonacci(input));
    }
}