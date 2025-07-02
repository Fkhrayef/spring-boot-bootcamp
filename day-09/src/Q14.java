
//  14. Write a Java program that reads an integer and check whether it is negative, zero, or
//  positive.
//  Test Data Input a number: 7 Expected Output :
//  Number is positive

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.println("Enter a number: ");
            int num = sc.nextInt();

            // Calculation
            if(num > 0) {
                System.out.println("Number is positive");
            } else if (num < 0) {
                System.out.println("Number is negative");
            } else {
                System.out.println("Number is zero");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }


    }
}
