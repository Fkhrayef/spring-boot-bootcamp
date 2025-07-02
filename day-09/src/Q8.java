import java.util.InputMismatchException;
import java.util.Scanner;

//  8 - Java program to convert the temperature in Centigrade to Fahrenheit
//  Enter temperature in Centigrade:
//        43
//  Temperature in Fahrenheit is: 109.4

// °F = (°C * 1.8) + 32.


public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Inputs
            System.out.println("Enter temperature in Centigrade: ");
            double c = sc.nextDouble();

            // Calculation
            double f = (c * 1.8) + 32;

            // Output
            System.out.println("Temperature in Fahrenheit is: " + f);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }
}
