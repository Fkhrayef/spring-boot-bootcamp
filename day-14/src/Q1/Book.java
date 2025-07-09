package Q1;

public class Book extends Product{
    // Attributes
    private String author;

    // Constructor
    public Book() {
    }

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    // Methods
    @Override
    public double getDiscount() {
        setPrice(getPrice() * 0.9);
        return getPrice();
    }

    // Getters and Setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // toString
    public String toString() {
        return "-----\nBook Title: " + getName() + "\nAuthor: " + getAuthor() + "\nPrice: " + getPrice() + "\n-----";
    }
}
