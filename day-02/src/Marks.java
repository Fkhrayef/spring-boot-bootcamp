import java.util.Scanner;

//  2. Write a program that takes the obtained marks and total marks as input and
//  calculates the percentage, then prints it.
//      • Input: Obtained Marks = 85, Total Marks = 100
//      • Expected Output: Percentage = 85.0%

public class Marks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("Enter obtained marks: ");
        double obtainedMarks = sc.nextDouble();

        System.out.print("Enter total marks: ");
        double totalMarks = sc.nextDouble();

        // Calculation
        double percentage = (obtainedMarks / totalMarks) * 100;

        // Output
        System.out.println("Your percentage is: " + percentage + "%");
    }
}
