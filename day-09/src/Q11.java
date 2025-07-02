
//  11. Write a Java program to compare two numbers.

//  Input Data:
//  Input first integer: 25
//  Input second integer: 39
//  Expected Output
//  25 != 39
//  25 < 39
//  25 <= 39

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.println("Enter 1st number: ");
            int num1 = sc.nextInt();
            System.out.println("Enter 2nd number: ");
            int num2 = sc.nextInt();

            // Calculation

            // == or != ?
            if (num1 == num2) {
                System.out.println(num1 + " = " + num2);
            } else {
                System.out.println(num1 + " != " + num2);
            }

            // > or < or ==?
            if (num1 > num2) {
                System.out.println(num1 + " > " + num2);
            } else if(num1 < num2) {
                System.out.println(num1 + " < " + num2);
            }

            // >= or <= ?
            if (num1 == num2) {
                System.out.println(num1 + " >= " + num2);
                System.out.println(num1 + " <= " + num2);
            } else if (num1 >= num2) {
                System.out.println(num1 + " >= " + num2);
            } else {
                System.out.println(num1 + " <= " + num2);
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
