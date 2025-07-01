
//  3.Write a program to find the k largest elements in a given array. Elements in the array can be in
//  any order.
//        2
//  Original Array:
//        [1, 4, 17, 7, 25, 3, 100]
//  Expected Output:
//        3 largest elements of the said array are:
//        100 25 17

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        // init the list
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(17);
        list.add(7);
        list.add(25);
        list.add(3);
        list.add(100);

        // input k
        System.out.println("Enter k (how many largest element(s) you want): ");
        int k = sc.nextInt();

        // array to hold the k largest elements
        int[] largestElements = new int[k];

        // Outer loop: loops k times to get k elements into the largestElements array
        for (int i = 0; i < k; i++) {
            int largest = 0;
            // Inner loop: Gets the largest element in the ArrayList
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) > list.get(largest)) {
                    largest = j;
                }
            }

            // Adds the largest element to the largestElements array
            largestElements[i] = list.get(largest);
            // Deletes the largest element from the ArrayList so we get the next largest
            // element in the next iteration
            list.remove(largest);
        }

        System.out.println(Arrays.toString(largestElements));
    }


}
