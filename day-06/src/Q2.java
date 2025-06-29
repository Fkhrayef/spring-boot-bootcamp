import java.util.ArrayList;
import java.util.Scanner;

//  2.Write a Java program to find the numbers greater than the average of the
//  numbers of a given array.
//  Original Array:
//  [1, 4, 17, 7, 25, 3, 100]
//  Expected Output:
//  The average of the said array is: 22.0 The numbers in the said array that are
//  greater than the average are: 25 100


public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while(true) {
            System.out.println("Enter a number to add to the array or 'q' to quit");

            if (sc.hasNextInt()) { // if int we continue adding to the ArrayList
                int num = sc.nextInt();
                numbers.add(num);

            } else { // otherwise we handle it as a string and check if it's "q" or something else
                String input = sc.next();

                if (input.equalsIgnoreCase("q")) { // if it's q we break out of the loop
                    break;
                } else { // otherwise we prompt the user to enter a valid value
                    System.out.println("Invalid input! Please enter a valid number or 'q' to quit.");
                }
            }
        }

        int sum = 0;
        for(Integer num : numbers) {
            sum += num;
        }

        double avg = (double) sum / numbers.size();

        System.out.println("The average is " + avg);
        System.out.println("Numbers greater than the avg are: ");
        for(Integer num : numbers) {
            if (num > avg) {
                System.out.print(num + " ");
            }
        }
    }
}
