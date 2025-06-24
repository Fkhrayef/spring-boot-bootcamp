import java.util.Scanner;

//  2.Take three numbers from the user and print the greatest number.

public class Greatest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("Enter 1st number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter 2nd number: ");
        int num2 = sc.nextInt();
        System.out.print("Enter 3rd number: ");
        int num3 = sc.nextInt();

        // Calculations

        // Assume num1 is the greatest
        int max = num1;

        // check if num2 is bigger than the current max, and update it accordingly
        if(num2 > max) {
            max = num2;
        }

        // check if num3 is bigger than the current max, and update it accordingly
        if(num3 > max) {
            max = num3;
        }

        System.out.println("The greatest number is " + max);
    }
}
