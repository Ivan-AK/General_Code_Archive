package GS06;

import java.util.Scanner;
import java.util.Random;

public class GS06_03_2 {

    static public class Ticket {
        public int price;
        private int Number;
        Ticket(int num) {
            price = 15;
            Number = num;
        }
        public int getPrice() {
            return price;
        }
        public int getNumber() {
            return Number;
        }
        public void objectString() {
            System.out.println("Number: " + Number + ", Price: " + getPrice());
        }
    }

    static public class WalkupTicket extends Ticket {
        WalkupTicket(int num) {
            super(num);
            super.price = 50;
        }
    }

    static public class AdvanceTicket extends Ticket {
        AdvanceTicket(int num, int days) {
            super(num);
            if(days < 10) {
                super.price = 40;
            }
            else {
                super.price = 30;
            }
        }
    }

    static public class StudentAdvanceTicket extends AdvanceTicket {
        public String ID;
        StudentAdvanceTicket(int num, int days, String id) {
            super(num, days);
            super.price = getPrice() / 2;
            ID = id;
        }
        public void objectString() {
            System.out.println("Ticket Number: " + getNumber() + ", Price: " + getPrice() +
                    ", Student id: " + ID);
        }
    }

    static public void main(String[] args) {
        Scanner console1 = new Scanner(System.in);
        Scanner console2 = new Scanner(System.in);
        Scanner console3 = new Scanner(System.in);
        Random r = new Random();
        int days = r.nextInt(21);
        String id = "";
        System.out.println(days + "Welcome! Have you come to buy tickets? Fantastic!");
        System.out.print("How many tickets will that be for you?\n\t----> ");
        int ticket_total = console1.nextInt();
        for (int i = 1; i <= ticket_total; ++i) {
            System.out.print("\nAre you a student of the illustrious Cedarcrest High School?\n\t----> ");
            char student = console2.nextLine().charAt(0);
            if (student == 'y' || student == 'Y') {
                System.out.print("\nOh! It's great to meet a fellow Redwolf once again!" +
                        " Now, please list out your student id.\n\t----> ");
                id = console3.nextLine();
            }
            System.out.println("\nAlright! Here you go!");
            if(days == 0) {
                WalkupTicket walk = new WalkupTicket(i);
                walk.objectString();
            }
            else {
                if(!(id.isEmpty())) {
                    StudentAdvanceTicket s_adv = new StudentAdvanceTicket(i, days, id);
                    s_adv.objectString();
                }
                else {
                    AdvanceTicket adv = new AdvanceTicket(i, days);
                    adv.objectString();
                }
            }
            if(i >= 1 && i != ticket_total) {
                System.out.println("\nPlease fill out the information for ticket #" + (i+1));
            }
            id = "";
        }
        System.out.println("\n\nThank you! Have a good day!\n");
    }
}
