public class Main {
    public static void main(String[] args) {
        System.out.println("===== Circle ======");
        Circle circle = new Circle(5);
        System.out.printf("Circle area: %.2f\n", circle.calculateArea());
        System.out.printf("Circle circumference: %.2f\n", circle.calculateCircumference());
        System.out.printf("Circle radius before: %.2f\n", circle.getRadius());
        circle.setRadius(10);
        System.out.printf("Circle radius after: %.2f\n", circle.getRadius());

        System.out.println();

        System.out.println("===== Rectangle ======");
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.printf("Rectangle area: %.2f\n", rectangle.calculateArea());
        System.out.printf("Rectangle perimeter: %.2f\n", rectangle.calculateCircumference());
        System.out.printf("Rectangle width before: %.2f\n", rectangle.getWidth());
        System.out.printf("Rectangle height before: %.2f\n", rectangle.getHeight());
        rectangle.setWidth(20);
        rectangle.setHeight(15);
        System.out.printf("Rectangle width after: %.2f\n", rectangle.getWidth());
        System.out.printf("Rectangle height after: %.2f\n", rectangle.getHeight());

        System.out.println();

        System.out.println("===== Triangle ======");
        Triangle triangle = new Triangle(8.66, 10);
        System.out.printf("Triangle area: %.2f\n", triangle.calculateArea());
        System.out.printf("Triangle perimeter: %.2f\n", triangle.calculateCircumference());
        System.out.printf("Triangle height before: %.2f\n", triangle.getHeight());
        System.out.printf("Triangle base before: %.2f\n", triangle.getBase());
        triangle.setHeight(20);
        triangle.setBase(15);
        System.out.printf("Triangle height after: %.2f\n", triangle.getHeight());
        System.out.printf("Triangle base after: %.2f\n", triangle.getBase());
    }
}