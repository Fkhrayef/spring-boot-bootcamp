
//  16 - Write a program that prompts the user to input an integer and then outputs the
//  number with the digits reversed.
//  For example, if the input is 12345, the output should be 54321.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.println("Enter number: ");
            String num = sc.next();

            // Calculations

//            if (!num.matches("[0-9]+")) {
//                System.out.println("Invalid number");
//            } else {
//                StringBuilder reversed = new StringBuilder(num);
//
//                // Output
//                System.out.println(reversed.reverse());
//            }

            // no need to the prev if statement since we are now handling errors
            isValid(num);

            StringBuilder reversed = new StringBuilder(num);

            // Output
            System.out.println(reversed.reverse());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }


    }

    public static void isValid(String num) throws Exception {
        if (!num.matches("[0-9]+")) {
            throw new Exception("input must be a number");
        }
    }
}
