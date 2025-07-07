public class Circle extends Shape {
    // Attributes
    private double radius;

    // Constructors
    public Circle() {
        this.radius = 1.0;
    }
    public Circle(double radius) {
        try {
            this.setRadius(radius);
        } catch (IllegalArgumentException e) {
            this.setRadius(1.0);
        }
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        try {
            this.setRadius(radius);
        } catch (IllegalArgumentException e) {
            this.setRadius(1.0);
        }
    }

    // Methods
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Getters and Setters
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        this.radius = radius;
    }

    // toString
    public String toString() {
        return "A circle with radius = " + radius + " which is a subclass of " + super.toString();
    }
}
