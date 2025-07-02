
//  10. Write a Java program to print the area and perimeter of a rectangle.
//  Test Data:
//  Width = 5.5 Height = 8.5
//  Expected Output
//  Area is 5.6 * 8.5 = 47.60
//  Perimeter is 2 * (5.6 + 8.5) = 28.20

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Inputs
            System.out.println("Enter width: ");
            double width = sc.nextDouble();
            isValid(width, "width");

            System.out.println("Enter height: ");
            double height = sc.nextDouble();
            isValid(height, "height");

            // Calculations
            double area = width * height;
            double perimeter = 2 * (width + height);

            // Output
            System.out.print("Area is: " + width + " x " + height + " = ");
            System.out.printf("%.2f", area);
            System.out.print("\nPerimeter is: 2 * (" + width + " + " + height + ")" + " = ");
            System.out.printf("%.2f", perimeter);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static void isValid(double num, String input) throws Exception {
        if (num < 0) {
            throw new Exception(input + " must be positive");
        }
    }
}
