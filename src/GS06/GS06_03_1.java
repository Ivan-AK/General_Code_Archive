package GS06;

import java.util.Scanner;
import java.util.Random;

public class GS06_03_1 {

    static public class Ticket {
        private int price = 15;
        public int getPrice() {
            return price;
        }
        public void objectString(int number, int days) {
            System.out.println("Number: " + number + ", Price: " + getPrice());
        }
    }

    static public class WalkupTicket extends Ticket {
        public int getPrice() {
            return super.getPrice() + 35;
        }
        public void objectString(int number, int days) {
            System.out.println("Number: " + number + ", Price: " + getPrice());
        }
    }

    static public class AdvanceTicket extends Ticket {
        public int getPrice(int days) {
            if (days >= 10) {
                return super.getPrice() + 15;
            }
            else {
                return super.getPrice() + 25;
            }
        }
        public void objectString(int number, int days) {
            System.out.println("Number: " + number + ", Price: " + getPrice(days));
        }
    }

    static public class StudentAdvanceTicket extends AdvanceTicket {
        public int getPrice(int days) {
            return super.getPrice(days) / 2;
        }
        public void objectString(int number, int days) {
            System.out.println("Number: " + number + ", Price: " + getPrice(days));
        }
    }

    public static void main(String[] args) {
        Scanner console1 = new Scanner(System.in);
        Scanner console2 = new Scanner(System.in);
        Random r = new Random();
        int days = r.nextInt(15);
        System.out.print(days + "Welcome! This program will let you buy tickets for our upcoming festival!" +
                "\nHow many tickets would you like to buy?\n\t----> ");
        int total = console1.nextInt();
        for(int i = 1; i <= total; ++i) {
            if (days <= 0) {
                WalkupTicket walk = new WalkupTicket();
                System.out.print("\nIt is the day of the event! Only Walk-up Tickets are available.\n");
                walk.objectString(i, days);
            }
            else {
                System.out.print("\nAre you a student?\n\t----> ");
                char stu = console2.nextLine().charAt(0);
                if(stu == 'y' || stu == 'Y') {
                    StudentAdvanceTicket sat = new StudentAdvanceTicket();
                    sat.objectString(i, days);
                }
                else {
                    AdvanceTicket at = new AdvanceTicket();
                    at.objectString(i, days);
                }
            }
        }
    }

}
