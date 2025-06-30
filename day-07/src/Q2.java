import java.util.Scanner;

//  2 - Write a Java method that check if the entered number is negative or
//  positive or zero


public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        int num = sc.nextInt();

        printNumberSign(num);
    }

    public static void printNumberSign(int num) {
        if(num > 0) {
            System.out.println("Positive Number");
        } else if (num < 0) {
            System.out.println("Negative Number");
        } else {
            System.out.println("Zero");
        }
    }
}
