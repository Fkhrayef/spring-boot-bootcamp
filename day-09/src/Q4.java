import java.util.InputMismatchException;
import java.util.Scanner;

//  4. Java program to find out the average of a set of integers

//  Enter the count of numbers:
//        5
//  Enter an integer:
//        3
//  Enter an integer:
//        8
//  Enter an integer:
//        6
//  Enter an integer:
//        7
//  Enter an integer:
//        2
//  The average is: 5.2


public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Inputs
            System.out.println("Enter the count of numbers: ");
            double count = sc.nextDouble();

            double sum = 0;

            for (int i = 0; i < count; i++) {
                System.out.println("Enter an integer: ");
                int num = sc.nextInt();

                sum += num;
            }

            System.out.println("The Avg is: " + sum/count);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }
}
