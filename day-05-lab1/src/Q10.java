
//  10. Write a Java program to print the area and perimeter of a rectangle.
//  Test Data:
//  Width = 5.5 Height = 8.5
//  Expected Output
//  Area is 5.6 * 8.5 = 47.60
//  Perimeter is 2 * (5.6 + 8.5) = 28.20

import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.println("Enter width: ");
        double width = sc.nextDouble();

        System.out.println("Enter height: ");
        double height = sc.nextDouble();

        // Calculations
        double area = width * height;
        double perimeter = 2 * (width + height);

        // Output
        System.out.print("Area is: " + width + " x " + height + " = ");
        System.out.printf("%.2f", area);
        System.out.print("\nPerimeter is: 2 * (" + width + " + " + height + " = ");
        System.out.printf("%.2f", perimeter);


    }
}
