import java.util.Scanner;

//  1 - Write a Java method to find the smallest number among three
//  numbers.
//  Test Data:
//  Input the first number: 25
//  Input the Second number: 37
//  Input the third number: 29
//  Expected Output:
//  The smallest value is 25.0


public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1st number: ");
        double num1 = sc.nextDouble();
        System.out.println("Enter 2nd number: ");
        double num2 = sc.nextDouble();
        System.out.println("Enter 3rd number: ");
        double num3 = sc.nextDouble();

        System.out.println(min(num1, num2, num3));

    }

    public static double min(double num1, double num2, double num3) {
        // There is a way with less code but for clarity I will do this:
        if (num1 < num2 && num1 < num3) {
            return num1;
        } else if (num2 < num1 && num2 < num3) {
            return num2;
        } else if (num3 < num1 && num3 < num2) {
            return num3;
        } else {
            return num1;
        }
    }
}