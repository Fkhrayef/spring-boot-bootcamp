import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//  5. Write a program that places the odd elements of an array before the
//  even elements.
//  Original Array:
//        [2,3,40,1,5,9,4,10,7]
//  Sample Output:
//        [3,1,5,9,7,2,40,4,10]


public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many numbers in your array?");
        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number in index " + i + ":");
            array[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i : array) {
            if (i % 2 == 1) {
                list.add(i);
            }
        }

        for (int i : array) {
            if (i % 2 == 0) {
                list.add(i);
            }
        }

        System.out.println("Array Before organizing");
        System.out.println(Arrays.toString(array));

        System.out.println("Array After organizing");
        System.out.println(list);


    }
}
