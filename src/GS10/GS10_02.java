package GS10;

import java.util.Scanner;
import java.lang.Math;

public class GS10_02 {

    public static int writeSquares(int input) {
        if(input == 0) {
            return input++;
        }
        else {
            if(input % 2 != 0) {
                System.out.print(Math.pow(input, 2) + ", ");
            }
            input = writeSquares(input - 1) + 1;
            if(input % 2 == 0) {
                System.out.print(Math.pow(input, 2) + ", ");
            }
        }
        return input;
    }

    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! Input a number and this program will output all the squared numbers leading up to the square of the input, inclusive of the input.");
        int input = console.nextInt();
        writeSquares(input);
    }
}