import java.util.Arrays;
import java.util.Scanner;

//  6. Write a program that test the equality of two arrays.
//        [2,3,6,6,4] [2,3,6,6,4]
//  Sample Output: true


public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // First Array
        System.out.println("How many numbers in your first array?");
        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number in index " + i + ":");
            array[i] = sc.nextInt();
        }

        // Second Array
        System.out.println("How many numbers in your second array?");
        int n2 = sc.nextInt();

        int[] array2 = new int[n2];

        for (int i = 0; i < array2.length; i++) {
            System.out.println("Enter number in index " + i + ":");
            array2[i] = sc.nextInt();
        }

        System.out.println(Arrays.equals(array, array2));
    }
}
