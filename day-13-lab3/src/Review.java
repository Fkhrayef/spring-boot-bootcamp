public class Review {
    // Attributes
    private String username;
    private int rating;
    private String comment;

    // Constructors
    public Review() {
    }

    public Review(String username, int rating, String comment) throws Exception {
        this.setUsername(username);
        this.setRating(rating);
        this.setComment(comment);
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws Exception {
        if (rating < 0 || rating > 5)
            throw new Exception();
        else
            this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) throws Exception {
        if (comment.length() > 20)
            throw new Exception();
        else
            this.comment = comment;
    }

    // toString
    @Override
    public String toString() {
        return "Review{" +
                "username='" + username + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
