import java.util.Scanner;

//  6.Write a program that prompts the user to input a positive integer. It
//  should then output a message indicating whether the number is a prime
//  number.

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter a positive number: ");
        int n = sc.nextInt();

        // Keep prompting for input until the user enters a valid input
        while (n <= 0) {
            System.out.println("Invalid number! Try again: ");
            n = sc.nextInt();
        }

        boolean isPrime = true;

        if (n == 1) {
            isPrime = false; // 1 is not prime
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(n + " is a prime number");
        } else {
            System.out.println(n + " is not a prime number");
        }

    }
}
