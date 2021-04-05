package GS06;

public class GS06_02 {

    static public class Ticket {
        public int price;
        private int Number;
        Ticket(int num) {
            price = 15;
            Number = num;
            System.out.println("HEY!");
        }
        public int getPrice() {
            return price;
        }
        public void objectString() {
            System.out.println("Number: " + Number + ", Price: " + getPrice());
        }
    }

    static public class WalkupTicket extends Ticket{
        WalkupTicket(int num) {
            super(num);
            super.price = 50;
            System.out.println("HEY!!");
            System.out.println(getPrice());
        }
    }

    static public void main(String[] args) {
        WalkupTicket obj = new WalkupTicket(3);
    }
}
