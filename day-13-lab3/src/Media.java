public class Media {
    // Attributes
    private String title;
    private String auteur;
    private String ISBN;
    private double price;

    // Constructors
    public Media() {
    }

    public Media(String title, String auteur, double price) throws Exception {
        this.setTitle(title);
        this.setAuteur(auteur);
        this.setPrice(price);
    }

    public Media(String title, String auteur, String ISBN, double price) throws Exception {
        this.setTitle(title);
        this.setAuteur(auteur);
        this.setISBN(ISBN);
        this.setPrice(price);
    }

    // Methods
    public String getMediaType() {
        return "Media";
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        if (title.length() > 18)
            throw new Exception("Title exceeds maximum length of 18");
        else
            this.title = title;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) throws Exception {
        if (auteur.length() > 12)
            throw new Exception("Auteur exceeds maximum length of 12");
        else
            this.auteur = auteur;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) throws Exception {
        if (ISBN.length() > 9)
            throw new Exception("ISBN exceeds maximum length of 9");
        else
            this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if (price < 0)
            throw new Exception("Price cannot be negative");
        else
            this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "Media{" +
                "title='" + title + '\'' +
                ", auteur='" + auteur + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", price=" + price +
                '}';
    }
}
