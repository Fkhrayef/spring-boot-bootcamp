
// 3. Write a Java program to print the area and perimeter of a circle.
//  Test Data:
//  Radius = 7.5
//  Expected Output
//  Perimeter is = 47.12388980384689
//  Area is = 176.71458676442586

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.println("Enter the radius: ");
        double radius = sc.nextDouble();

        // Calculations
        double perimeter = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;

        // Output
        System.out.println("Perimeter is = " + perimeter);
        System.out.println("Area is = " + area);
    }
}
