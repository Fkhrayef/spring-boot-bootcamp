import java.util.Scanner;

//  2. Write a Java program to reverse a string.
//  Test Data: Input a string: The quick brown fox Expected Output: Reverse
//  string: xof nworb kciuq ehT

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter a string to reverse: ");
        String string = sc.nextLine();

        // Start from the last index of the string (length - 1 because string's
        // index start from 0) and print each char until i reaches 0
        for (int i = string.length() - 1; i >= 0; i--) {
            System.out.print(string.charAt(i));
        }
    }
}
