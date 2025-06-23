import java.util.Scanner;

//  4. Create a program that takes a string as input, calculates its length, and then
//  reverses the string using the StringBuilder class, finally printing both the length and
//  reversed string.
//      • Input: "Hello, World!"
//      • Expected Output: Length of the string: 13 And Reversed string: "!dlroW ,olleH"

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String string = sc.nextLine();

        // Calculations
        int length = string.length();
        StringBuilder reversedString = new StringBuilder(string);
        reversedString.reverse();

        // Output
        System.out.println("Length of the string: " + length);
        System.out.println("Reversed String: " + reversedString);
    }
}
