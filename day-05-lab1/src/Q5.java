import java.util.Scanner;

//  5. Write a Java program that accepts three integers as input, adds the first two integers
//  together, and then determines whether the sum is equal to the third integer.

//  Sample Output:
//  Input the first number : 5
//  Input the second number: 10
//  Input the third number : 15
//  The result is: true
//        --------
//  Input the first number : 10
//  Input the second number: 20
//  Input the third number : 25
//  The result is: false


public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.println("Enter the first number: ");
        int num1 = sc.nextInt();

        System.out.println("Enter the second number: ");
        int num2 = sc.nextInt();

        System.out.println("Enter the third number: ");
        int num3 = sc.nextInt();

        // Calculation
        if(num1+num2 == num3) {
            System.out.println("The result is: true");
        } else {
            System.out.println("The result is: false");
        }
    }
}
