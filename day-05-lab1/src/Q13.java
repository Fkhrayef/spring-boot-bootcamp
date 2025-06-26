
//  13. Write a Java program that accepts four integers from the user and prints equal if all
//  four are equal, and not equal otherwise.
//  Sample Output:
//  Input first number: 25
//  Input second number: 37
//  Input third number: 45
//  Input fourth number: 23
//  Numbers are not equal!

import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1st number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter 2nd number: ");
        int num2 = sc.nextInt();
        System.out.println("Enter 3rd number: ");
        int num3 = sc.nextInt();
        System.out.println("Enter 4th number: ");
        int num4 = sc.nextInt();

        if (num1 == num2 && num2 == num3 && num3 == num4) {
            System.out.println("Numbers are equal");
        } else {
            System.out.println("Numbers are not equal");
        }
    }
}
