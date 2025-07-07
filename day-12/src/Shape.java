public class Shape {
    // Attributes
    private String color;
    private boolean filled;

    // Constructors
    public Shape() {
        color = "green";
        filled = true;
    }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Getters and Setters
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // toString
    public String toString() {
        return "A Shape of color " + color + " is " + (filled ? "filled" : "not filled");
    }
}
