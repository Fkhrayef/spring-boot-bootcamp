import java.util.Scanner;

//  6. Write a Java program to reverse a word.
//  Sample Output:
//  Input a word: dsaf
//  Reverse word: fasd


public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter a string to reverse: ");
        String string = sc.nextLine();

        // Calculation
        StringBuilder reversed = new StringBuilder(string);

        // Output
        System.out.println(reversed.reverse());
    }
}
