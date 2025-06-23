import java.util.Scanner;

//  1. Develop a program that takes the weight (in kilograms) and height (in meters)
//  as input and calculates the BMI, then prints it.
//      • Input: Weight (kg) = 70, Height (m) = 1.75
//      • Expected Output: BMI = 22.86

public class BMI {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter your weight (kg): ");
        double weight = sc.nextDouble();

        System.out.print("Enter your height (m): ");
        double height = sc.nextDouble();

        // Calculation
        double BMI = (weight) / ((height) * (height));

        // Output the result
        System.out.println("Your BMI is " + BMI);
    }
}