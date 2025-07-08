import java.util.ArrayList;

public class User {
    // Attributes
    private String username;
    private String email;
    private ArrayList<Media> purchaseMediaList;
    private ArrayList<Media> shoppingCart;

    // Constructors
    public User() {
        purchaseMediaList = new ArrayList<Media>();
        shoppingCart = new ArrayList<Media>();
    }

    public User(String username, String email) throws Exception {
        this.setUsername(username);
        this.setEmail(email);
        purchaseMediaList = new ArrayList<>();
        shoppingCart = new ArrayList<>();
    }

    public User(String username, String email, ArrayList<Media> purchaseMediaList, ArrayList<Media> shoppingCart) throws Exception {
        this.setUsername(username);
        this.setEmail(email);
        this.setPurchaseMediaList(purchaseMediaList);
        this.setShoppingCart(shoppingCart);
    }

    // Methods
    public void addToCart(Media media) {
        shoppingCart.add(media);
    }

    public void addToPurchaseMedia(Media media) {
        purchaseMediaList.add(media);
    }

    public void removeFromCart(Media media) {
        shoppingCart.remove(media);
    }

    public void checkOut() {
        ArrayList<Media> successfullyPurchased = new ArrayList<>();

        // Check if the books are in stock
        for (Media media : shoppingCart) {
            if (media instanceof Book) {
                try {
                    ((Book) media).purchase(this);
                    successfullyPurchased.add(media);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // add to the purchase list
        purchaseMediaList.addAll(successfullyPurchased);
        // clear the shopping cart
        shoppingCart.clear();
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws Exception {
        if (username.length() > 12)
            throw new Exception("Username length must be less than 12");
        else
            this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
//        String regex = "^\\S+@\\S+\\.\\S+$";
        if (!email.matches("^\\S+@\\S+\\.\\S+$"))
            throw new Exception("Invalid email");
        else
            this.email = email;
    }

    public ArrayList<Media> getPurchaseMediaList() {
        return purchaseMediaList;
    }

    public void setPurchaseMediaList(ArrayList<Media> purchaseMediaList) {
        this.purchaseMediaList = purchaseMediaList;
    }

    public ArrayList<Media> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Media> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    // toString
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", purchaseMediaList=" + purchaseMediaList +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
