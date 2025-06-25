import java.util.Scanner;

//  5.Write a program that reads a set of integers, and then prints the sum of
//  the even and odd integers.

public class EvenOddSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int evenSum = 0;
        int oddSum = 0;

        while (true) {
            System.out.print("Enter a number (or 'q' to quit): ");

            // Since the input can be either int or string, we have to check what it is!

            if (sc.hasNextInt()) { // if it's a number we take it and add it to its respective sum (even or odd)
                int num = sc.nextInt();
                if (num % 2 == 0) {
                    evenSum += num;
                } else {
                    oddSum += num;
                }
            } else { // otherwise we handle it as a string and check if it's "q" or something else
                String input = sc.next();

                if (input.equalsIgnoreCase("q")) { // if it's q we break out of the loop
                    break;
                } else { // otherwise we prompt the user to enter a valid value
                    System.out.println("Invalid input! Please enter a valid number or 'q' to quit.");
                }
            }
        }

        System.out.println("Even sum: " + evenSum);
        System.out.println("Odd sum: " + oddSum);
    }
}
