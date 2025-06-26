
//  7 - Java program to check whether the given number is even or odd
//  Enter a number:
//        33
//  The number is Odd
//  Enter a number:
//        24
//  The number is Even

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.println("Enter a number");
        int num = sc.nextInt();

        if(num % 2 == 0) {
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");
        }
    }
}
