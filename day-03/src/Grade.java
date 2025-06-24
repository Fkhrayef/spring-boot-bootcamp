import java.util.Scanner;

//  4. Write a program that takes a numeric score as input and prints
//  the corresponding letter grade using the following grading scale:
//  A: 90-100
//  B: 80-89
//  C: 70-79
//  D: 60-69
//  F: 0-59

public class Grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter your mark: ");
        int mark = sc.nextInt();

        if(mark < 0 || mark > 100) {
            System.out.println(mark + " is an invalid input");
        }
        else if (mark >= 90) {
            System.out.println("Numeric Score: " + mark + "\nGrade: A");
        } else if (mark >= 80) {
            System.out.println("Numeric Score: " + mark + "\nGrade: B");
        } else if (mark >= 70) {
            System.out.println("Numeric Score: " + mark + "\nGrade: C");
        } else if (mark >= 60) {
            System.out.println("Numeric Score: " + mark + "\nGrade: D");
        } else {
            System.out.println("Numeric Score: " + mark + "\nGrade: F");
        }
    }
}
