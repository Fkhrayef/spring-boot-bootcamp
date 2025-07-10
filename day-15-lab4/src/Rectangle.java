public class Rectangle extends Shape {
    // Attributes
    private double width;
    private double height;

    // Constructor
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    // Methods
    @Override
    public double calculateArea() {
        return getHeight() * getWidth();
    }

    @Override
    public double calculateCircumference() {
        return 2 * (getHeight() + getWidth());
    }

    // Getters and Setters
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
