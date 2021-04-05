package GS06;

import java.util.Random;

public class GS06_04 {

    public interface Shape {
        public double getArea();
        public double getPerimeter();
    }

    static public class Hexagon implements Shape{
        private double side_length;
        Hexagon(int side_length) {
            this.side_length = side_length;
        }
        public double getArea() {
            return Math.round(((3*Math.sqrt(3)/2)*Math.pow(this.side_length, 2)*100))/100;
        }
        public double getPerimeter() {
            return(6*this.side_length);
        }
    }

    static public void main(String[] args) {
        Random r = new Random();
        Hexagon hex = new Hexagon(r.nextInt(75));
        System.out.println("Area: " + hex.getArea() + ", Perimeter: " + hex.getPerimeter());
    }
}
