public class Rectangle extends Shape {
    // Attributes
    private double width;
    private double length;

    // Constructors
    public Rectangle() {
        width = 1.0;
        length = 1.0;
    }
    public Rectangle(double width, double length) {
        try {
            this.setWidth(width);
            this.setLength(length);
        } catch (IllegalArgumentException e) {
            this.setWidth(1.0);
            this.setLength(1.0);
        }
    }
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        try {
            this.setWidth(width);
            this.setLength(length);
        } catch (IllegalArgumentException e) {
            this.setWidth(1.0);
            this.setLength(1.0);
        }
    }

    // Methods
    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    // Getters and Setters
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width must be a positive number");
        }
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length must be a positive number");
        }
        this.length = length;
    }

    // toString
    public String toString() {
        return "A Rectangle with width = " + width + " and length = " + length + " which is a subclass of " + super.toString();
    }
}
