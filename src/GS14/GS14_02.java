package GS14;

import java.util.Scanner;

public class GS14_02 {

    public static boolean isReverse(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        else if(s1.length() <= 1) {
            if(s1.compareToIgnoreCase(s2) == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        if(s1.substring(0, 1).compareToIgnoreCase(s2.substring(s2.length() - 1)) == 0) {
            s2 = s2.substring(0, s2.length() - 1);
        }
        s1 = s1.substring(1);
        return isReverse(s1, s2);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! This program determines if two strings are reverses of one another, regardless of capitalization.");
        System.out.print("Please input the first string here ---> ");
        String s1 = console.nextLine();
        System.out.print("\nPlease input the second string here ---> ");
        String s2 = console.nextLine();
        System.out.println("\n\nThe two strings are reverse: " + isReverse(s1, s2));
    }
}
