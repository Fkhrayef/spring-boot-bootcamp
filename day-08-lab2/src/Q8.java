
//  8. Create a method that generates the Fibonacci sequence up to a specified number of terms.
//        Hint: The Fibonacci sequence is a mathematical sequence of numbers that starts with 0 and 1,
//  and each subsequent number in the sequence is the sum of the two preceding ones.
//  Example:
//  Enter the number of Fibonacci terms to generate: 10
//  Expected Output:
//  Fibonacci sequence with 10 terms:
//        0 1 1 2 3 5 8 13 21 34

import java.util.Arrays;
import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of Fibonacci terms to generate: ");
        int n = sc.nextInt();

        // Print the sequence
        System.out.println("Sequence: " + Arrays.toString(fibonacciSequence(n)));

        // Print the result (Bonus)
        System.out.println("(Bonus) Result = " + fibonacciAnswer(n));
    }

    public static int[] fibonacciSequence(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] = 0; // it's already 0 but for clarity.
            } else if (i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        return arr;
    }

    public static int fibonacciAnswer(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciAnswer(n-1) + fibonacciAnswer(n-2);
        }

    }
}
