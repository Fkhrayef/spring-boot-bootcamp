abstract public class Shape {
    // this is stated in the first paragraph but not in the UML so,
    // I just added it. it doesn't do anything since we don't have
    // a constructor for Shape, and we are not asked to provide
    // these values in subclasses constructors.
    private int x;
    private int y;

    public abstract double calculateArea();
    public abstract double calculateCircumference();
}
