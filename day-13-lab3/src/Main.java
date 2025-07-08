import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Users instantiation =====");
        User user1 = null;
        User user2 = null;
        User user3 = null;
        try {
            user1 = new User("Faisal", "Faisal@gmail.com");
            user2 = new User("Abdullah", "Abdullah@gmail.com");
            user3 = new User("Ramy", "Ramy@gmail.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        System.out.println(user1);
        System.out.println(user2);

        System.out.println();

        System.out.println("===== Store instantiation =====");
        Store store = new Store();
        System.out.println(store);

        System.out.println();

        System.out.println("===== Reviews instantiation =====");
        Review review1 = null;
        Review review2 = null;
        Review review3 = null;
        try {
            review1 = new Review("Faisal", 5, "Great Read!");
            review2 = new Review("Nasser", 5, "Nice one!");
            review3 = new Review("Khalid", 4, "Readable");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Review> reviews = new ArrayList<>();
        reviews.add(review1);
        reviews.add(review2);
        reviews.add(review3);
        System.out.println(review1);
        System.out.println(review2);
        System.out.println(review3);

        System.out.println();

        System.out.println("===== Books instantiation =====");
        Book book1 = null;
        Book book2 = null;
        Novel novel = null;
        AcademicBook academicBook = null;
        try {
            book1 = new Book("Linguistics", "Ramy", "324-329", 99, 5, reviews);
            book2 = new Book("Management Life", "Sara", "432-324", 5.99, 0, reviews);
            System.out.println(book1);
            novel = new Novel("Little mermaid", "Laura", "346-75", 9.99, 0, reviews, "Kids");
            System.out.println(novel);
            academicBook = new AcademicBook("String Theory", "Jack Fish", "0435-234", 56.99, 1, reviews, "Science");
            System.out.println(academicBook);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println("===== Movies instantiation =====");
        Movie movie1 = null;
        try {
            movie1 = new Movie("The Titanic", "George", 5, 220);
            System.out.println(movie1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println("===== Music instantiation =====");
        Music music1 = null;
        try {
            music1 = new Music("Country", "Samy", 2.99, "Samy");
            System.out.println(music1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Group all media in a list
        ArrayList<Media> media = new ArrayList<>();
        media.add(book1);
        media.add(novel);
        media.add(academicBook);
        media.add(movie1);
        media.add(music1);

        System.out.println();

        System.out.println("===============================");
        System.out.println("========= Media Types =========");
        System.out.println("===============================");


        System.out.println("book1: " + (book1 != null ? book1.getMediaType() : null));
        System.out.println("novel: " + (novel != null ? novel.getMediaType() : null));
        System.out.println("academicBook: " + (academicBook != null ? academicBook.getMediaType() : null));
        System.out.println("movie1: " + (movie1 != null ? movie1.getMediaType() : null));
        System.out.println("music1: " + (music1 != null ? music1.getMediaType() : null));


        System.out.println();

        System.out.println("===============================");
        System.out.println("=========== Testing ===========");
        System.out.println("===============================");

        System.out.println();

        System.out.println("===== Store =====");

        System.out.println();

        System.out.println("----- Display users of the store -----");
        System.out.println(store.displayUsers());

        System.out.println();

        System.out.println("----- Add users to the store -----");
        store.setUsers(users);
        System.out.println(store);

        System.out.println();

        System.out.println("----- Add a user to the store -----");
        store.addUser(user3);
        System.out.println(store);

        System.out.println();

        System.out.println("----- Display users of the store -----");
        System.out.println(store.displayUsers());

        System.out.println();

        System.out.println("----- Display media of the store -----");
        System.out.println(store.displayMedia());

        System.out.println();

        System.out.println("----- Add Media to the store -----");
        store.setMedia(media);
        System.out.println(store);

        System.out.println();

        System.out.println("----- Add a media to the store -----");
        store.addMedia(book2);
        System.out.println(store);

        System.out.println();

        System.out.println("----- search for a book in the store -----");
        Book searched = store.searchBook("Linguistics");
        if (searched != null)
            System.out.println(store.searchBook("Linguistics"));
        else
            System.out.println("No book found");

        System.out.println();

        System.out.println("----- Display media of the store -----");
        System.out.println(store.displayMedia());

        System.out.println();

        System.out.println("===== User =====");

        System.out.println();

        System.out.println("----- Display user's shopping cart -----");
        if (user1 != null) {
            System.out.println(user1.getShoppingCart());
        }

        System.out.println();

        System.out.println("----- Add 2 books to user's cart -----");
        if (user1 != null) {
            user1.addToCart(book1);
            user1.addToCart(novel);
        }

        System.out.println();

        System.out.println("----- Display user's shopping cart -----");
        if (user1 != null) {
            System.out.println(user1.getShoppingCart());
        }

        System.out.println();

        System.out.println("----- Remove a book from user's cart -----");
        if (user1 != null) {
            user1.removeFromCart(novel);
        }

        System.out.println();

        System.out.println("----- Checkout -----");
        if (user1 != null) {
            System.out.println("Shopping Cart Before: " + user1.getShoppingCart());
            System.out.println("Purchase Media List Before: " + user1.getPurchaseMediaList());
            user1.checkOut();
            System.out.println("Shopping Cart After: " + user1.getShoppingCart());
            System.out.println("Purchase Media List After: " + user1.getPurchaseMediaList());
        }

        System.out.println();

        System.out.println("----- Checkout (Fail due to stock) -----");
        if (user1 != null) {
            user1.addToCart(novel);
            user1.checkOut();
        }

        System.out.println();

        System.out.println("===== Book =====");

        System.out.println();

        System.out.println("----- Get book Average Rating -----");

        if (book1 != null) {
            System.out.println("Average Rating: " + book1.getAverageRating());
            System.out.println("Is bestseller? " + book1.isBestseller());
        }

        System.out.println();

        System.out.println("----- Restock a Book -----");
        if (novel != null) {
            System.out.println(novel.getTitle() + "'s stock before: " + novel.getStock());
            try {
                novel.restock(20);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(novel.getTitle() + "'s stock after: " + novel.getStock());
        }

        System.out.println();

            System.out.println("===== Movie =====");

        System.out.println();

        System.out.println("----- Watch a movie -----");
        if (user1 != null) {
            System.out.println("User's purchased media list before: " + user1.getPurchaseMediaList());
            if (movie1 != null) {
                movie1.watch(user1);
            }
            System.out.println("User's purchased media list after: " + user1.getPurchaseMediaList()); // Movie added
        }

        System.out.println();

        System.out.println("----- Recommend similar movies -----");
        Movie movie2 = null;
        Movie movie3 = null;
        try {
            movie2 = new Movie("Romeo & Golliet", "George", 5, 220);
            movie3 = new Movie(100); // just to prove we're not returning every movie
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie2);
        movies.add(movie3);

        if (movie1 != null) {
            ArrayList<Movie> recommendedMovies =  movie1.recommendSimilarMovies(movies);
            for (Movie movie : recommendedMovies) {
                System.out.println(movie.getTitle());
            }
        }

        System.out.println();

        System.out.println("===== Music =====");

        System.out.println();

        System.out.println("----- Listen to a music -----");
        if (user1 != null) {
            System.out.println("User's purchased media list before: " + user1.getPurchaseMediaList());
            if (music1 != null) {
                music1.listen(user1);
            }
            System.out.println("User's purchased media list after: " + user1.getPurchaseMediaList()); // Music added
        }

        System.out.println();

        System.out.println("----- Generate Playlist  -----");
        Music music2 = null;
        Music music3 = null;
        try {
            music2 = new Music("Home Away", "Samy", 5, "Samy");
            music3 = new Music("Loay"); // just to prove we're not returning every music
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Music> musics = new ArrayList<>();
        musics.add(music2);
        musics.add(music3);

        if (music1 != null) {
            ArrayList<Music> recommendedMusic =  music1.generatePlayList(musics);
            for (Music music : recommendedMusic) {
                System.out.println(music.getTitle());
            }
        }

        System.out.println();
    }
}