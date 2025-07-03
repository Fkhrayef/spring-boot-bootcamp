
// 1. Write a Java program that accept three numbers from
// the user and print the largest number .

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1st number");
        double num1 = sc.nextDouble();

        System.out.println("Enter 2nd number");
        double num2 = sc.nextDouble();

        System.out.println("Enter 3rd number");
        double num3 = sc.nextDouble();

        double largest = num1;

        if (num2 > largest) {
            largest = num2;
        }

        if (num3 > largest) {
            largest = num3;
        }

        System.out.println("Largest Number is: " + largest);


    }
}