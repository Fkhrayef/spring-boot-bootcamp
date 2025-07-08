import java.util.ArrayList;

public class Movie extends Media {
    // Attributes
    private int duration;

    // Constructors
    public Movie() {
        super();
    }

    public Movie(int duration) throws Exception {
        super();
        this.setDuration(duration);
    }

    public Movie(String title, String auteur, double price, int duration) throws Exception {
        super(title, auteur, price);
        this.setDuration(duration);
    }

    // Methods
    public void watch(User user) {
        user.addToPurchaseMedia(this);
    }

    public ArrayList<Movie> recommendSimilarMovies(ArrayList<Movie> movieCatalog) {
        ArrayList<Movie> similarMovies = new ArrayList<>();
        for (Movie movie : movieCatalog) {
            if (getAuteur().equals(movie.getAuteur())) {
                similarMovies.add(movie);
            }
        }
        return similarMovies;
    }

    @Override
    public String getMediaType() {
        if (getDuration() >= 120)
            return "Long Movie";
        else
            return "Movie";
    }

    // Getters and Setters
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) throws Exception {
        if (duration < 0)
            throw new Exception("Duration cannot be negative");
        else
            this.duration = duration;
    }

    // toString
    @Override
    public String toString() {
        return "Movie{" +
                "duration=" + duration +
                '}';
    }
}
