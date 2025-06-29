
//  4.Write a Java program to swap the first and last elements of an array and
//  create a new array.
//  Original Array:
//  [20, 30, 40]
//  Sample Output:
//  New array after swapping the first and last elements: [40, 30, 20]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many numbers in your array?");
        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number in index " + i + ":");
            array[i] = sc.nextInt();
        }

        ArrayList<Integer> swapped = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if(!(i == 0 || i == array.length - 1)) {
                swapped.add(array[i]);
            }
        }

        swapped.add(0, array[array.length - 1]);
        swapped.add(array[0]);

        System.out.println("Array Before swapping");
        System.out.println(Arrays.toString(array));

        System.out.println("Array After swapping");
        System.out.println(swapped);
    }
}
