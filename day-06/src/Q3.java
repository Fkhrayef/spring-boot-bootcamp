import java.util.Scanner;

//  3.Write a Java program to get the larger value between first and last
//  element of an array of integers.
//  Original Array:
//  [20, 30, 40]
//  Sample Output:
//  Larger value between first and last element: 40


public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many numbers in your array?");
        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number in index " + i + ":");
            array[i] = sc.nextInt();
        }


        if(array[0] > array[array.length - 1]) {
            System.out.println("Largest Value between First and Last Element: " + array[0]);
        } else if(array[0] < array[array.length - 1]) {
            System.out.println("Largest Value between First and Last Element: " + array[array.length - 1]);
        } else {
            System.out.println("First and Last Element are equal: " + array[0]);
        }

    }
}
