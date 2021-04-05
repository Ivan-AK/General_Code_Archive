package GS11;

import java.util.Scanner;
import java.lang.Math;

public class GS11_05 {

    public static int getFibonacci(int iteration_target) {
        return getFibonacci(Math.abs(iteration_target), 0, 1);
    }

    private static int getFibonacci(int iteration_target, int number1, int number2) {
        int number3 = 0;
        System.out.println(number1);
        if(iteration_target == 0) {
            return number2;
        }
        else {
            number3 = number1 + number2;
            return getFibonacci(iteration_target - 1, number2, number3);
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! Enter a number and this program will print the values up to the according iteration in the Fibonacci Sequence.");
        int iteration_target = console.nextInt();
        System.out.println(getFibonacci(iteration_target));
    }
}
