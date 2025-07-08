import java.util.ArrayList;

public class AcademicBook extends Book {
    // Attributes
    private String subject;

    // Constructors
    public AcademicBook() {
        super();
    }

    public AcademicBook(String subject) throws Exception {
        super();
        this.setSubject(subject);
    }

    public AcademicBook(int stock, ArrayList<Review> reviews, String subject) throws Exception {
        super(stock, reviews);
        this.setSubject(subject);
    }

    public AcademicBook(String title, String auteur, String ISBN, double price, int stock, ArrayList<Review> reviews, String subject) throws Exception {
        super(title, auteur, ISBN, price, stock, reviews);
        this.setSubject(subject);
    }

    // Methods
    @Override
    public String getMediaType() {
        if (getAverageRating() >= 4.5)
            return "Bestselling AcademicBook";
        else
            return "AcademicBook";
    }

    // Getters and Setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) throws Exception {
        if (subject.length() >= 12)
            throw new Exception("Subject length must be less than 12");
        else
            this.subject = subject;
    }

    // toString
    @Override
    public String toString() {
        return "AcademicBook{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
