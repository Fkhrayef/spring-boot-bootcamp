
//  1. Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of
//  two numbers , takes two numbers as input
//
//  Test Data:
//  Input first number: 125
//  Input second number: 24
//  Expected Output :
//        125 + 24 = 149
//        125 x 24 = 3000
//        125 - 24 = 101
//        125 / 24 = 5
//        125 mod 24 = 5

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Inputs
            System.out.println("Enter 1st number");
            int num1 = sc.nextInt();

            System.out.println("Enter 2nd number");
            int num2 = sc.nextInt();

            // I can move this down to allow other operations but division, but I decided to not allow it at all.
            if (num2 == 0) {
                throw new Exception("Can't divide by 0");
            }

            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
            System.out.println(num1 + " x " + num2 + " = " + (num1 * num2));
            System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
            System.out.println(num1 + " ÷ " + num2 + " = " + (num1 / num2));
            System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }
}