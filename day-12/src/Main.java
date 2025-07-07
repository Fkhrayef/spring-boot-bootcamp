public class Main {
    public static void main(String[] args) {
        System.out.println("===== Shape =====");

        Shape shape1 = new Shape();
        System.out.println("Shape no-args constructor: " + shape1);
        Shape shape2 = new Shape("blue", false);
        System.out.println("Shape full constructor: " + shape2);

        System.out.println();

        System.out.println("--- Shape Methods ---");
        System.out.println("Setting Color to cyan and filled to false");
        try {
            shape2.setColor("cyan");
            shape2.setFilled(false);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Get Color: " + shape2.getColor());
        System.out.println("Get Filled: " + shape2.isFilled());

        System.out.println();

        System.out.println("===== Circle =====");
        Circle circle1 = new Circle();
        System.out.println("Circle no-args constructor: " + circle1);
        Circle circle2 = new Circle(5);
        System.out.println("Circle 1 arg constructor: " + circle2);
        Circle circle3 = new Circle(3.5, "yellow", false);
        System.out.println("Circle full constructor: " + circle3);

        System.out.println();

        System.out.println("--- Circle Methods ---");
        System.out.println("Setting Radius to 2");
        try {
            circle3.setRadius(2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Get Radius: " + circle3.getRadius());
        System.out.println("Get Area: " + circle3.getArea());
        System.out.println("Get Perimeter: " + circle3.getPerimeter());

        System.out.println();

        System.out.println("===== Rectangle =====");
        Rectangle rectangle1 = new Rectangle();
        System.out.println("Rectangle no-args constructor: " + rectangle1);
        Rectangle rectangle2 = new Rectangle(5.0, 3.0);
        System.out.println("Rectangle 2 args constructor: " + rectangle2);
        Rectangle rectangle3 = new Rectangle(5.0, 3.0, "orange", false);
        System.out.println("Rectangle full constructor: " + rectangle3);

        System.out.println();

        System.out.println("--- Rectangle Methods ---");
        System.out.println("Setting Length to 2 and Width to 3");
        try {
            rectangle3.setLength(2);
            rectangle3.setWidth(3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Get Length: " + rectangle3.getLength());
        System.out.println("Get Width: " + rectangle3.getWidth());
        System.out.println("Get Area: " + rectangle3.getArea());
        System.out.println("Get Perimeter: " + rectangle3.getPerimeter());

        System.out.println();

        System.out.println("===== Square =====");
        Square square1 = new Square();
        System.out.println("Square no-args constructor: " + square1);
        Square square2 = new Square(5);
        System.out.println("Square 1 arg constructor: " + square2);
        Square square3 = new Square(3.5, "yellow", false);
        System.out.println("Square full constructor: " + square3);

        System.out.println();

        System.out.println("--- Square Methods ---");
        System.out.println("Setting Side to 4");
        try {
            square3.setSide(4);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Get side: " + square3.getSide());
        System.out.println("Get Area: " + square3.getArea());
        System.out.println("Get Perimeter: " + square3.getPerimeter());

        System.out.println();
    }
}