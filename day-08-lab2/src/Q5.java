
//  5. Write a menu-driven Java program with following option:
//      1. Accept elements of an array
//      2. Display elements of an array
//      3. Search the element within array
//      4. Sort the array
//      5. To Stop
//      the size of the array should be entered by the user.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int size = sc.nextInt();

        int[] arr = new int[size];
        int choice = 0;

        do {
            printMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print("Enter the " + i + " element: ");
                        arr[i] = sc.nextInt();
                    }

                    System.out.println("\nArray has been updated successfully: " + Arrays.toString(arr));
                    // case 1 was utilizing this method but since the need of passing sc, I made it in place.
//                    acceptArray(arr, sc);
                    break;
                case 2:
                    displayArray(arr);
                    break;
                case 3:
                    System.out.println("Enter an element to search for: ");
                    int element = sc.nextInt();
                    searchElement(arr, element);
                    break;
                case 4:
                    sortArray(arr);
                    break;
                case 5:
                    System.out.println("Exited Successfully!");
            }
        } while (choice != 5);
    }

    public static void printMenu() {
        System.out.println("Choose an option:\n" +
                "1. Accept elements of an array\n" +
                "2. Display elements of an array\n" +
                "3. Search the element within array\n" +
                "4. Sort the array\n" +
                "5. To Stop");
    }

    public static void acceptArray(int[] arr, Scanner sc) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the " + i + " element: ");
            arr[i] = sc.nextInt();
        }

        System.out.println("\nArray has been updated successfully: " + Arrays.toString(arr));
    }

    public static void displayArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void searchElement(int[] arr, int element) {

        ArrayList<Integer> elementIndices = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                elementIndices.add(i);
            }
        }

        System.out.println("Element was found in the following indices: " + elementIndices);
    }

    public static void sortArray(int[] arr) {

        // Manual Sort
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Array has been sorted: " + Arrays.toString(arr));
    }
}
