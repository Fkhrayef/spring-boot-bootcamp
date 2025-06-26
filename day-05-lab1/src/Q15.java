
//  15.Write a program to enter the numbers till the user wants and at the end it
//  should display the count of positive, negative and zeros entered (End loop use -1 ,
//  Don’t count -1).
//  Test data
//  1
//  3
//  0
//  -2
//  -4
//  -1
//  2 positives
//  1 zero
//  2 negatives

import java.util.Scanner;

public class Q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = -1;

        int sumOfPositives = 0;
        int sumOfNegatives = 0;
        int sumOfZero = 0;

        do {
            System.out.println("Enter a number: ");
            num = sc.nextInt();

            if (num > 0) {
                sumOfPositives++;
            } else if (num < 0 && num != -1) {
                sumOfNegatives++;
            } else if (num == 0) {
                sumOfZero++;
            } else {
                System.out.println("Exited");
            }

        } while (num != -1);

        System.out.println(sumOfPositives + " Positives");
        System.out.println(sumOfZero + " Zeros");
        System.out.println(sumOfNegatives + " Negatives");
    }
}
