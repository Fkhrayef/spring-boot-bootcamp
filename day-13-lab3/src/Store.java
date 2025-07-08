import java.util.ArrayList;

public class Store {
    // Attributes
    private ArrayList<User> users;
    private ArrayList<Media> media;

    // Constructors
    public Store() {
        users = new ArrayList<>();
        media = new ArrayList<>();
    }

    public Store(ArrayList<User> users, ArrayList<Media> media) {
        this.setUsers(users);
        this.setMedia(media);
    }

    // Methods
    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> displayUsers() {
        return users;
    }

    public void addMedia(Media media) {
        this.media.add(media);
    }

    public ArrayList<Media> displayMedia() {
        return media;
    }

    public Book searchBook(String title) {
        for (Media media : media) {
            if (media.getTitle().equals(title) && media instanceof Book) {
                return (Book) media;
            }
        }
        return null;
    }

    // Getters and Setters
    // duplicate
//    public ArrayList<User> getUsers() {
//        return users;
//    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    // duplicate
//    public ArrayList<Media> getMedia() {
//        return media;
//    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

    // toString
    @Override
    public String toString() {
        return "Store users: " + displayUsers() + "\nStore media: " + displayMedia();
    }
}
