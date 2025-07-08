import java.util.ArrayList;

public class Book extends Media {
    // Attributes
    private int stock;
    private ArrayList<Review> reviews;

    // Constructors
    public Book() {
        super();
        reviews = new ArrayList<Review>();
    }

    public Book(int stock, ArrayList<Review> reviews) throws Exception {
        super();
        this.setStock(stock);
        this.setReviews(reviews);
    }

    public Book(String title, String auteur, String ISBN, double price, int stock, ArrayList<Review> reviews) throws Exception {
        super(title, auteur, ISBN, price);
        this.setStock(stock);
        this.setReviews(reviews);
    }

    // Methods
    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        double sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        return sum / reviews.size();
    }

    public void purchase(User user) throws Exception {
        if (stock > 0)
            stock--;
        else
            throw new Exception("Stock not available");
    }

    public boolean isBestseller() {
        return this.getAverageRating() >= 4.5; // if avg rating above 4.5 it's a bestseller
    }

    public void restock(int quantity) throws Exception {
        if (quantity <= 0)
            throw new Exception("Quantity must be greater than 0");
        else {
            stock += quantity;
            System.out.println("Restocked Successfully!");
        }
    }

    @Override
    public String getMediaType() {
        if (isBestseller())
            return "Bestselling Book";
        else
            return "Book";
    }

    // Getters and Setters
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws Exception {
        if (stock < 0)
            throw new Exception("Stock must be greater than 0");
        else
            this.stock = stock;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    // toString
    @Override
    public String toString() {
        return "Book{" +
                "stock=" + stock +
                ", reviews=" + reviews +
                '}';
    }
}
