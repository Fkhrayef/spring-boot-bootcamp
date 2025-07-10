public class Circle extends Shape {
    // Attributes
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Methods
    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
    @Override
    public double calculateCircumference() {
        return 2 * Math.PI * getRadius();
    }

    // Getters and Setters
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
