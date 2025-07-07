public class Square extends Rectangle {
    // Attributes

    // Constructors
    public Square() {
        super(); // will create a square with side = 1.0
    }
    public Square(double side) {
        super(side, side);
    }
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    // Getters and Setters
    public double getSide() {
        return super.getLength(); // or width doesn't matter
    }
    public void setSide(double side) {
        if (side < 0) {
            throw new IllegalArgumentException("Side cannot be negative");
        }
        super.setLength(side);
        super.setWidth(side);
    }

    // toString
    public String toString() {
        return "A Square with side = " + getSide() + " which is a subclass of " + super.toString();
    }
}
