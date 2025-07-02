
//  9.Write a Java program that takes a string and a number from the user,then prints the
//  character in the given index.

//  Test Data:
//      Input a string: Java Bootcamp
//      Input a number: 1
//      Expected Output:
//      a

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Inputs
            System.out.println("Enter a string");
            String s = sc.nextLine();

            System.out.println("Enter an index");
            int index = sc.nextInt();

            // Calculation

//            // check if the index is not out of bound
//            if(index > s.length() - 1 || index < 0) {
//                System.out.println("Invalid index");
//            } else {
//                char letter = s.charAt(index);
//
//                // Output
//                System.out.println(letter);
//            }

            // no need for prev if statement since we are catching the error now!
            char letter = s.charAt(index);

            // Output
            System.out.println(letter);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }


    }
}
