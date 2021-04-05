package GS05;

import java.util.Random;
import java.util.Scanner;

public class GS05_03 {

    static int code_length = 4; //If you want to make the key longer, you change it here.
    static String test_key = "1112"; //Spot for inputting a known value. Used mainly for testing.

    public static char[] generate_new_key() { //Simply generates a random key, if there is no value in the test_key area.
        char[] key = new char[code_length];
        Random rand = new Random();
        for(int i = 0; i < 4; ++i) {
            if(test_key.isEmpty()) {
                key[i] = Integer.toString(rand.nextInt(10)).charAt(0);
            }
            else {
                key = test_key.toCharArray();
            }
        }
        for(int i = 0; i < code_length; ++i) {
            System.out.print(key[i]);
        }
        return key;
    }

    /* public static int[] check(char[] key, char[] guess) {
        boolean pass = true;
        int[] pin_results = new int[2];
        char[] guess_record = new char[code_length];
        for(int i = 0; i < guess_record.length; ++i) {
            guess_record[i] = ' ';
        }
        for(int i = 0; i < code_length; ++i) {
            for(int k = 0; k < code_length; ++k) {
                if(guess[i] == key[k]) {
                    for(int c = 0; c < code_length; ++c) {
                        if(guess[i] == guess_record[c]) {
                            pass = false;
                        }
                    }
                    if(i == k) {
                        ++pin_results[0];
                    }
                    else if(pass == true) {
                        ++pin_results[1];
                    }
                    guess_record[i] = guess[i];
                    pass = true;
                }
            }
        }
        System.out.print("\n\nAmount of digits of the correct value and position (Black Pins):             " + pin_results[0]);
        System.out.print("\nAmount of digits of the correct value but incorrect position (White Pins):   " + pin_results[1]);
        return pin_results;
    } */

    public static int[] check(char[] key, char[] guess) {
        int[] pin_results = new int[2];
        int[] base_key = new int[10]; //these "base..." arrays will store information regarding how many of a number is present in the key/guess.
        int[] base_guess = new int[10];
        for(int i = 0; i < 10; ++i) { //Sets initial conditions
            base_key[i] = 0;
            base_guess[i] = 0;
        }
        for(int i = 0; i < code_length; ++i) { //Tracks how many of a number there is in both the key and the guess
            ++base_key[Character.getNumericValue(key[i])];
            //System.out.print(base_key[Character.getNumericValue(key[i])]);    TESTING OUTPUTS
            ++base_guess[Character.getNumericValue(guess[i])];
            //System.out.print(base_guess[Character.getNumericValue(guess[i])]); TESTING OUTPUTS
        }
        for(int i = 0; i < 10; ++i) {
            if(base_key[i] > 0) {
                if(base_guess[i] > base_key[i]) { //This "if" statement will stop weird stuff from happening with duplicate numbers
                    //base_guess[i] -= base_key[i];
                    base_guess[i] = Math.min(base_guess[i], base_key[i]);
                }
                pin_results[1] += base_guess[i];
            }
        }

        for(int i = 0; i < code_length; ++i) {
            for (int k = 0; k < code_length; ++k) { //The Black Pin is, by FAR, the simplest pin to recognize.
                if (guess[i] == key[k]) { //These simple loops and "if" statements check each character of the guess against the key.
                    if(i == k) {
                        ++pin_results[0];
                    }
                }
            }
        }
        pin_results[1] = pin_results[1] - pin_results[0];
        if(pin_results[1] < 0) { //Sometimes the amount of White Pins can dip below zero, this is like a barrier. It does not affect the accuracy of the answer.
            pin_results[1] = 0;
        }
        System.out.print("\n\nAmount of digits of the correct value and position (Black Pins):             " + pin_results[0]);
        System.out.print("\nAmount of digits of the correct value but incorrect position (White Pins):   " + pin_results[1]);
        return pin_results;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        char[] key = generate_new_key(); //Look to the method above
        char[] guess = new char[code_length]; //Stores the users guess
        System.out.print("\n\nWelcome! This program will simulate a game of Mastermind. Never played? Well, it's pretty simple!\n" +
                "Mastermind is somewhat of a guessing game. One person or, in this case, I will come up with a code that you, the player, needs to guess.\n" +
                "The code will be four numbers ranging from 0 to 9. You have an infinite amount of guesses. After each guess is entered " +
                "I will tell you how \nmany numbers in your guess matched the value and position of those in the key. \nI will also tell you if" +
                "there are any numbers that match a value of one in the key, yet is out of place. Use this information well!\n\n" +
                "The key has been generated! Guess a(n) " + code_length + " digit number.");
        /* do {
            System.out.print("\n\n\t-----> ");
            String temp_guess = console.nextLine();
            for (int i = 0; i < code_length; ++i) {
                guess[i] = temp_guess.charAt(i);
            }
        } while(check(key, guess)[0] != code_length); */

        boolean exit = false;
        while(!exit) {
            System.out.print("\n\n\t-----> ");
            String temp_guess = console.nextLine(); //String is used to store information so that it can be moved in pieces.
            for (int i = 0; i < code_length; ++i) {
                guess[i] = temp_guess.charAt(i);
            }
            if(check(key, guess)[0] == code_length) { //If the guess triggers the maximum amount of black pins, the player wins.
                System.out.print("\n\nCongratulations! You have guessed correctly! Thank you for playing!\n");
                exit = true;
            }
        }
    }
}
