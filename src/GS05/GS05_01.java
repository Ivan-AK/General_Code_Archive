package GS05;

import java.util.Scanner;

public class GS05_01 {

    public static boolean detect_win(char[][] fill) {
            for (int i = 0; i < 3; i++) {
                if (fill[0][i] == fill[1][i] && fill[1][i] == fill[2][i] && fill[0][i] == fill[2][i] && fill[1][i] != ' ') {
                    return true;
                }
                if (fill[i][0] == fill[i][1] && fill[i][1] == fill[i][2] && fill[i][0] == fill[i][2] && fill[i][1] != ' ') {
                    return true;
                }
            }
        if(fill[0][0] == fill[1][1] && fill[1][1] == fill[2][2] && fill[0][0] == fill[2][2] && fill[1][1] != ' ') {
            return true;
        }
        else if(fill[0][2] == fill[1][1] && fill[1][1] == fill[2][0] && fill[0][2] == fill[2][0] && fill[1][1] != ' ') {
            return true;
        }
        else if(fill[0][0] != ' ' && fill[0][1] != ' ' && fill[0][2] != ' ' &&
                fill[1][0] != ' ' && fill[1][1] != ' ' && fill[1][2] != ' ' &&
                fill[2][0] != ' ' && fill[2][1] != ' ' && fill[2][2] != ' ') {
            return true;
        }
        else {
            return false;
        }
    }

    public static char[][] drawTic(char[][] fill) {
        int fillCounter = 0; //A counter independent of the loop counters
        int fillCounter2 = 0;
        char[][] tic_tac_toe = new char[5][5];
        for(int i = 0; i < 5; i++) {
            for(int k = 0; k < 5; k++) {
                if(i % 2 == 0 || i == 0) {
                    if(k % 2 == 0 || k == 0) {
                        tic_tac_toe[i][k] = fill[fillCounter2][fillCounter%3]; //positioning the user input
                        fillCounter++;
                    }
                    else {
                        tic_tac_toe[i][k] = '|';
                    }
                }
                else {
                    tic_tac_toe[i][k] = '-';
                }
            }
            if(i % 2 == 0) {
                fillCounter2++;
            }
        }
        return tic_tac_toe;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int position;
        char[] temp;
        boolean exit = false;
        char[][] fill = new char[3][3]; //Array for the entered information
        System.out.print("Welcome! This program will print out a complete Tic-Tac-Toe Board. " +
                "To fill in the board, type a character and press enter. \n" +
                "After entering the X or O, input a number 1-9 that will assign the character a spot on the board.\n" +
                "The board is numbered like such:\n\n\t1 | 2 | 3\n\t---------\n\t4 | 5 | 6\n\t---------\n\t7 | 8 | 9\n");
        while(!exit) {
            System.out.print("\n\tEnter an 'X' or an 'O' ----> ");
            temp = in.nextLine().toCharArray();
            System.out.print("\n\tEnter a position ----> ");
            position = console.nextInt();
            if(3 < position && position <= 6) {
                fill[1][position - 4] = temp[0];
            }
            else if(6 < position) {
                fill[2][position - 7] = temp[0];
            }
            else {
                fill[0][position - 1] = temp[0];
            }
            for(int k = 0; k < 3; ++k) {
                for (int i = 0; i < 3; ++i) {
                    if (fill[k][i] == 0) {
                        fill[k][i] = ' ';
                    }
                }
            }

            /* for(int i = 0; i < 3; i++) {
                for(int k = 0; k < 3; k++) {
                    System.out.print(fill[i][k]);
                }
            } */

            char[][] tic_tac_toe = drawTic(fill);
            for (int i = 0; i < 5; i++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(tic_tac_toe[i][k]);
                    if (k == 4) {
                        System.out.print("\n");
                    }
                }
            }
            if(detect_win(fill) == true) {
                System.out.print("\n\n\t\tGAME COMPLETE\n\n\n");
                exit = true;
            }
        }
    }
}