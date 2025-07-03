
// 3. Write a program to enter the numbers till the user
// wants and at the end it should display the sum entered.


import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        while(true) {
            System.out.println("Enter a number to add or 0 to quit: ");
            int num = sc.nextInt();

            if (num == 0) { // I made it 0 because it doesn't affect the sum
                break;
            } else {
                sum += num;
            }
        }

        System.out.println("Sum = " + sum);
    }
}
