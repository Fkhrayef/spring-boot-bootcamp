import java.util.Scanner;

//  3. Write a program to find the factorial value of any number entered
//  through the keyboard

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        // Keep prompting for input until the user enters a valid input
        while (n < 0) {
            System.out.println("Invalid number! Try again: ");
            n = sc.nextInt();
        }

        // Calculations
        int factorial = 1;
        for (int i = n; i > 0; i--) {
            factorial = factorial * i;
        }

        // Output
        System.out.println("Factorial = " + factorial);

    }
}
