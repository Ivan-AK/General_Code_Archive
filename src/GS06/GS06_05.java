package GS06;

import java.util.Random;

public class GS06_05 {

    public interface Shape_3D {
        public double getVolume();
        public double getSurfaceArea();
    }

    static public class Sphere implements Shape_3D{
        public double radius;
        Sphere(double radius) {
            this.radius = radius;
        }
        public double getVolume() {
            return (4/3)*Math.PI*Math.pow(radius, 3);
        }
        public double getSurfaceArea() {
            return 4*Math.PI*Math.pow(radius, 2);
        }
    }
    static public class Cone extends Sphere{
        public double height;
        Cone(double radius, double height) {
            super(radius);
            this.height = height;
        }
        public double getSurfaceArea() {
            return Math.PI*Math.pow(radius, 2)+Math.PI*radius*(Math.sqrt(Math.pow(radius, 2)+Math.pow(height, 2)));
        }
        public double getVolume() {
            return (1/3)*Math.PI*Math.pow(radius, 2)*height;
        }
    }
    static public class Cylinder extends Cone {
        Cylinder(double radius, double height) {
            super(radius, height);
        }
        public double getSurfaceArea() {
            return 2*Math.PI*Math.pow(radius, 2)+2*Math.PI*radius*height;
        }
        public double getVolume() {
            return Math.PI*Math.pow(radius, 2)*height;
        }
    }


    static public class Cube implements Shape_3D{
        public double side_length1;
        Cube(double side_length1) {
            this.side_length1 = side_length1;
        }
        public double getSurfaceArea() {
            return 6*Math.pow(side_length1, 2);
        }
        public double getVolume() {
            return Math.pow(side_length1, 3);
        }
    }
    static public class Rectangle extends Cube {
        public double side_length2;
        public double side_length3;
        Rectangle(double side_length1, double side_length2, double side_length3) {
            super(side_length1);
            this.side_length2 = side_length2;
            this.side_length3 = side_length3;
        }
        public double getSurfaceArea() {
            return 2*(side_length1*side_length2) + 2*(side_length1*side_length3) + 2*(side_length2*side_length3);
        }
        public double getVolume() {
            return side_length1 * side_length2 * side_length3;
        }
    }


    static public void main(String[] args) {
        Random r = new Random();
        double radius = r.nextInt(10) + 1;
        double height = r.nextInt(10) + 1;
        double side_length1 = r.nextInt(10) + 1;
        double side_length2 = r.nextInt(10) + 1;
        double side_length3 = r.nextInt(10) + 1;

        Sphere sphere = new Sphere(radius);
        Cone cone = new Cone(radius, height);
        Cylinder cylinder = new Cylinder(radius, height);

        Cube cube = new Cube(side_length1);
        Rectangle rectangle = new Rectangle(side_length1, side_length2, side_length3);

        System.out.println("Radius: " + radius);
        System.out.println("Height: " + height);
        System.out.println("Side 1: " + side_length1);
        System.out.println("Side 2: " + side_length2);
        System.out.println("Side 3: " + side_length3);

        System.out.println("Sphere Surface Area: " + Math.round(sphere.getSurfaceArea()) + ", Sphere Volume: " + Math.round(sphere.getVolume()));
        System.out.println("Cone Surface Area: " + Math.round(cone.getSurfaceArea()) + ", Cone Volume: " + Math.round(cone.getVolume()));
        System.out.println("Cylinder Surface Area: " + Math.round(cylinder.getSurfaceArea()) + ", Cylinder Volume: " + Math.round(cylinder.getVolume()));
        System.out.println("Cube Surface Area: " + cube.getSurfaceArea() + ", Cube Volume: " + cube.getVolume());
        System.out.println("Rectangle Surface Area: " + rectangle.getSurfaceArea() + ", Rectangle Volume: " + rectangle.getVolume());
    }
}
