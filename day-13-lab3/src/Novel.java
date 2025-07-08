import java.util.ArrayList;

public class Novel extends Book {
    // Attributes
    private String genre;

    // Constructors
    public Novel() {
        super();
    }

    public Novel(String genre) throws Exception {
        super();
        this.setGenre(genre);
    }

    public Novel(int stock, ArrayList<Review> reviews, String genre) throws Exception {
        super(stock, reviews);
        this.setGenre(genre);
    }

    public Novel(String title, String auteur, String ISBN, double price, int stock, ArrayList<Review> reviews, String genre) throws Exception {
        super(title, auteur, ISBN, price, stock, reviews);
        this.setGenre(genre);
    }

    // Methods
    @Override
    public String getMediaType() {
        if (getAverageRating() >= 4.5)
            return "Bestselling Novel";
        else
            return "Novel";
    }

    // Getters and Setters
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) throws Exception {
        if (genre.length() > 12)
            throw new Exception("Genre length must be less than 12");
        else
            this.genre = genre;
    }

    // toString
    @Override
    public String toString() {
        return "Novel{" +
                "genre='" + genre + '\'' +
                '}';
    }
}
