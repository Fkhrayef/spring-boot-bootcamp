package Q1;

public abstract class Product {
    // Attributes
    private String name;
    private double price;

    // Constructor
    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Methods
    public abstract double getDiscount();

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
