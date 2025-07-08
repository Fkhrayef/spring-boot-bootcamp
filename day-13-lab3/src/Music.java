import java.util.ArrayList;

public class Music extends Media {
    // Attributes
    private String artist; // this is just dummy, I'm using the parent's auteur instead

    // Constructors
    public Music() {
        super();
    }

    public Music(String artist) throws Exception {
        super();
        this.setArtist(artist);
    }

    public Music(String title, String auteur, double price, String artist) throws Exception {
        super(title, auteur, price);
        this.setArtist(artist);
    }

    // Methods
    public void listen(User user) {
        // I assume this will be like watch() in Movie class
        user.addToPurchaseMedia(this);
    }

    public ArrayList<Music> generatePlayList(ArrayList<Music> musicCatalog) {
        ArrayList<Music> similarSongs = new ArrayList<>();
        for (Music song : musicCatalog) {
            if (getAuteur().equals(song.getAuteur())) {
                similarSongs.add(song);
            }
        }
        return similarSongs;
    }

    @Override
    public String getMediaType() {
        if(getPrice() >= 10)
            return "Premium Music";
        else
            return "Music";
    }

    // Getters and Setters
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) throws Exception {
        if (artist.length() >= 12)
            throw new Exception("artist length should be less than 12");
        else
            this.artist = artist;
    }

    // toString
    @Override
    public String toString() {
        return "Music{" +
                "artist='" + artist + '\'' +
                '}';
    }
}
