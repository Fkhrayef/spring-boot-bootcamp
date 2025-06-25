import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter the base number: ");
        int base = sc.nextInt();

        System.out.println("Enter the power number: ");
        int power = sc.nextInt();

        // Calculations
        int result = 1;
        for (int i = 0; i < power; i++) {
            result = result * base;
        }

        // Output
        System.out.println(base + "^" + power + " = " + result);
    }
}
