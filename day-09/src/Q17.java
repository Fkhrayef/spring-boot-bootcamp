
//  17 - Write a program to enter the numbers till the user wants and at the end the
//  program should display the largest and smallest numbers entered.
//  enter the number : 4
//  enter the number : 5
//  enter the number : -1
//  enter the number : 9
//  the large number : 9
//  the small number : -1

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            double max = 0;
            double min = 0;

            while (true) {
                System.out.print("Enter a number (or 'q' to quit): ");

                // Since the input can be either int or string, we have to check what it is!

                if (sc.hasNextDouble()) {
                    double num = sc.nextDouble();
                    if (max == 0) {
                        max = num;
                    }
                    if (min == 0) {
                        min = num;
                    }
                    if (num > max) {
                        max = num;
                    }
                    if (num < min) {
                        min = num;
                    }
                } else { // otherwise we handle it as a string and check if it's "q" or something else
                    try {
                        String input = sc.next();

                        if (input.equalsIgnoreCase("q")) { // if it's q we break out of the loop
                            break;
                        } else { // otherwise we prompt the user to enter a valid value
                            throw new Exception("Invalid input! Please enter a valid number or 'q' to quit.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            System.out.println("Maximum: " + max);
            System.out.println("Minimum: " + min);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }


    }
}
