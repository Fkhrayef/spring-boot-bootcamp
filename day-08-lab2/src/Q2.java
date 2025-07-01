
//  2. Write a program that displays the number of occurrences of an element in the array.
//  Original Array:
//        [1,1,1,3,3,5]
//  Sample Output:
//      3 occurs 2 times
//      1 occurs 3 times
//      9 occurs 0 time

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1,1,1,3,3,5};

        int count = 0;

        // I assumed looping until the input doesn't occur in the arr
        // as visible in the expected output when 9 didn't occur the
        // program stopped.
        do {
            count = 0;
            System.out.println("Enter a number to see its occurrence count");
            int n = sc.nextInt();

            for (int num : arr) {
                if (num == n) {
                    count++;
                }
            }

            // I noticed when the count is 0 the expected output says time (without s)
            // that can be solved using if else, but I feel it was just a typo.
            System.out.println(n + " occurs " + count + " times");
        } while (count != 0);

    }
}
