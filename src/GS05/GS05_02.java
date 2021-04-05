package GS05;

import java.util.Random;
import java.util.Scanner;

public class GS05_02 {

    public static char[] keyMaker() {
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] key = new char[4];
        for(int i = 0; i < 4; ++i) {
            key[i] = alphabet.charAt(r.nextInt(alphabet.length()));
        }
        return key;
    }

    public static boolean[] check(char[] key, char guess) {
        boolean[] checkboard = new boolean[key.length];
        for(int i = 0; i < checkboard.length; ++i) {
            checkboard[i] = false;
        }
        for(int i = 0; i < key.length; ++i) {
            if (guess == key[i]) {
                checkboard[i] = true;
            }
        }
        return checkboard;
    }

    public static void drawHangman(int stage) {
        if(stage == 1) {
            System.out.print("\n\n---------\n    |\n    O");
        }
        else if(stage == 2) {
            System.out.print("\n\n---------\n    |\n    O");
            System.out.print("\n    |");
        }
        else if(stage == 3) {
            System.out.print("\n\n---------\n    |\n    O");
            System.out.print("\n    |");
            System.out.print("\n   /");
        }
        else if(stage == 4) {
            System.out.print("\n\n---------\n    |\n    O");
            System.out.print("\n    |");
            System.out.print("\n   / \\");
        }
        else if(stage == 5) {
            System.out.print("\n\n---------\n    |\n    O");
            System.out.print("\n    |\\");
            System.out.print("\n   / \\");
        }
        else if(stage == 6) {
            System.out.print("\n\n---------\n    |\n    O");
            System.out.print("\n   /|\\");
            System.out.print("\n   / \\");
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        char[] key;
        key = keyMaker();
        int stage = 0;
        int score = 0;
        boolean c = false;
        boolean badguess = false;
        boolean exit = false;
        char guess;
        int tries = 0;
        char[] record = new char[40];
        System.out.print("Welcome! This is a simple game of Hangman. A random string of 4 letters have been selected as the key. Guess away! ");

        for(int i = 0; i < key.length; ++i) { //This loop is to display the key. For testing purposes only. Comment out if you want to play legit.
            System.out.print(key[i]);
        }

        while(!exit) {
            System.out.print("\n\t----> ");
            guess = console.nextLine().charAt(0);
            for(int i = 0; i < tries; ++i) {
                if (guess == record[i]) {
                    System.out.print("\nYou've already guessed that. Try again!");
                    badguess = true;
                }
            }
            if(!badguess) {
                record[tries] = guess;
                tries++;
                for (int i = 0; i < key.length; ++i) {
                    if (check(key, guess)[i] == true) {
                        System.out.print("\nCorrect!");
                        c = true;
                        score++;
                    }
                }
                if (!c) {
                    System.out.print("\nIncorrect!");
                    drawHangman(++stage);
                }
                c = false;
                if (stage == 6) {
                    System.out.print("\nYou have failed!");
                    exit = true;
                } else if (score == key.length) {
                    System.out.print("\nYou have won!");
                    exit = true;
                }
            }
            badguess = false;
        }
    }
}
