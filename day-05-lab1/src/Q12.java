
//  12. Write a Java program to convert seconds to hours, minutes and seconds.
//  Sample Output:
//  Input seconds: 86399
//  23:59:59

import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter seconds: ");
        int seconds = sc.nextInt();

        // Calculation

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secondsLeft = minutes % 60;

        // Output
        System.out.printf("%02d:%02d:%02d", hours, minutes, secondsLeft);
    }
}
