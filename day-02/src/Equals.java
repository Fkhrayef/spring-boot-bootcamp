import java.util.Scanner;

//  8. Write a program that takes two strings as input and check if they are equal,
//  ignoring the case, then prints whether they are equal or not.
//      • Input: String 1 = "Hello", String 2 = "hello"
//      • Expected Output: Strings are equal (ignoring case).

public class Equals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("Enter the first string: ");
        String string1 = sc.nextLine();

        System.out.print("Enter the second string: ");
        String string2 = sc.nextLine();

        // Calculations
        boolean isEqual = string1.equalsIgnoreCase(string2);

        // Output ( NOTE: Couldn't customize the output because I can't use conditions! )
        System.out.println("String are equal? " + isEqual);

    }
}
