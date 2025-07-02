import java.util.InputMismatchException;
import java.util.Scanner;

//  2. Write a Java program that takes a number as input and prints its multiplication table up to
//  10.
//  Test Data:
//  Input a number: 8 Expected
//  Output :
//        8 x 1 = 8
//        8 x 2 = 16
//        8 x 3 = 24
//        ...
//        8 x 10 = 80


public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Inputs
            System.out.println("Enter a number");
            int num = sc.nextInt();

            for (int i = 1; i <= 10 ; i++) {
                System.out.println(num + " x " + i + " = " + num*i);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }
}
