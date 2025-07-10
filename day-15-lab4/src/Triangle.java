public class Triangle extends Shape {
    // Attributes
    private double height;
    private double base;

    // Constructor
    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    // Methods
    @Override
    public double calculateArea() {
        return (getBase() * getHeight()) / 2;
    }

    @Override
    public double calculateCircumference() {
        // equilateral triangle
        return 3 * getBase();
    }

    // Getters and Setters
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
}
