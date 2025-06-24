import java.util.Scanner;

//  3. Create a program that takes an amount in one currency and an exchange rate
//  as input, then converts and prints the amount in another currency.
//      • Input: Amount in USD = 100, Exchange Rate (USD to EUR) = 0.85
//      • Expected Output: Amount in EUR = 85.0

public class Currency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter amount in USD: ");
        double amount = sc.nextDouble();

        System.out.print("Enter the exchange rate: (e.g. USD to EUR = 0.85): ");
        double exchangeRate = sc.nextDouble();

        // Calculation ( 1 USD = 0,85 EUR )
        amount = amount * exchangeRate;

        // Output
        System.out.println("Amount = " + amount);
    }
}
