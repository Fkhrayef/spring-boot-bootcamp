package Q1;

public class Movie extends Product {
    // Attributes
    private String director;

    // Constructors
    public Movie() {
    }

    public Movie(String name, double price, String director) {
        super(name, price);
        this.director = director;
    }

    // Methods
    @Override
    public double getDiscount() {
        setPrice(getPrice() * 0.8);
        return getPrice();
    }

    // Getters and Setters
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // toString
    public String toString() {
        return "-----\nMovie Title: " + getName() + "\nDirector: " + getDirector() + "\nPrice: " + getPrice() + "\n-----";
    }

}
