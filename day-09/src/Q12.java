
//  12. Write a Java program to convert seconds to hours, minutes and seconds.
//  Sample Output:
//  Input seconds: 86399
//  23:59:59

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.println("Enter seconds: ");
            int seconds = sc.nextInt();

            isValid(seconds);

            // Calculation
            int hours = seconds / 3600;
            int minutes = (seconds % 3600) / 60;
            int secondsLeft = minutes % 60;

            // Output
            System.out.printf("%02d:%02d:%02d", hours, minutes, secondsLeft);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static void isValid(int seconds) {
        if (seconds < 0) {
            try {
                throw new Exception("Seconds must be positive");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }
}
