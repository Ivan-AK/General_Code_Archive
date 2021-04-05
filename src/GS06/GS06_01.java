package GS06;

public class GS06_01 {

    static public class Ticket {
        private int price;
        private int Number;
        Ticket(int number) {
            price = 15;
            Number = number;
        }
        public int getPrice() {
            return price;
        }
        public void objectString() {
            System.out.println("Number: " + Number + ", Price: " + getPrice());
        }
    }

    static public void main(String[] args) {
    }
}
