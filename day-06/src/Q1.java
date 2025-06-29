import java.util.Scanner;

// 1.Write a Java program to test if the first and the last element of an array of
//  integers are same. The length of the array must be greater than or equal to 2
//  Test Data:
//  array = 50, -20, 0, 30, 40, 60, 10
//  Sample Output: false


public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many numbers in your array?");
        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number in index " + i + ":");
            array[i] = sc.nextInt();
        }

        if (array.length < 2) {
            System.out.println("Array is too short");
        } else {
            if(array[0] == array[array.length - 1]) {
                System.out.println("First and Last Elements are Equal");
            } else {
                System.out.println("First and Last Elements are Not Equal");
            }
        }
    }
}