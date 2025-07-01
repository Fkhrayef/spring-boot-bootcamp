import java.util.Random;
import java.util.Scanner;

//  6. Create a method that generates a random number within a given range. Allow the user to
//  specify the range and call the method to display random numbers.
//        Hint: use Random class
//  Sample Output:
//        3
//  Enter the minimum value of the range: 10
//  Enter the maximum value of the range: 100
//  Enter the number of random numbers to generate: 5 Random
//  numbers within the specified range:
//        71 - 98 - 96 - 71 - 71


public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the minimum value of the range: ");
        int min = sc.nextInt();

        System.out.print("Enter the maximum value of the range: ");
        int max = sc.nextInt();

        System.out.print("Enter the number of random numbers to generate: ");
        int count = sc.nextInt();

        printElements(generateRandoms(min, max, count));
    }

    public static int[] generateRandoms(int min, int max, int count) {
        Random random = new Random();
        int[] randomNumbers = new int[count];

        for (int i = 0; i < count; i++) {
            randomNumbers[i] = random.nextInt(max-min) + min;
        }

        return randomNumbers;
    }

    public static void printElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + " - ");
            } else {
                System.out.print(arr[i]);
            }
        }
    }
}
