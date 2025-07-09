import Q1.Book;
import Q1.Movie;
import Q2.MoveablePoint;

public class Main {
    public static void main(String[] args) {
        System.out.println("============ Q1 =============");
        System.out.println("=== Items Before Discount ===");
        Book book = new Book("Java", 20.0, "Faisal");
        System.out.println(book);
        Movie movie = new Movie("Avengers", 10.0, "Martin");
        System.out.println(movie);
        System.out.println("=== Items After Discount ===");
        System.out.println("Book price: " + book.getDiscount() + " (-10%)"); // Books are discounted by 10%
        System.out.println("Movie price: " + movie.getDiscount() + " (-20%)"); // Movies are discounted by 20%

        System.out.println();

        System.out.println("============ Q2 =============");
        MoveablePoint moveablePoint = new MoveablePoint(10, 10, 1, 1);
        System.out.println("=== Point Before Moving ===");
        System.out.println(moveablePoint);
        System.out.println("=== Point After Moving a step up and a step to the right ===");
        // our speed is already 1 let's move!
        moveablePoint.moveUp();
        moveablePoint.moveRight();
        System.out.println(moveablePoint);
        System.out.println("=== Point After Moving 4 steps down and 2 steps to the right ===");
        // Adjust the speed to reduce code lines, 4 for ySpeed and 2 for xSpeed
        // Instead of repeated 1-step moves
        moveablePoint.setySpeed(4);
        moveablePoint.setxSpeed(2);
        moveablePoint.moveDown();
        moveablePoint.moveLeft();
        System.out.println(moveablePoint);
    }
}