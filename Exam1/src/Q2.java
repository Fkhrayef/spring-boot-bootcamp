
// 2. Write a Java program that accept a String and a number
// from the user,then print the character in the given index.

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String s = sc.nextLine();

        System.out.println("Enter an index to print: ");
        int index = sc.nextInt();

        if (index < 0 || index > s.length() - 1) {
            System.out.println("Invalid index");
        } else {
            System.out.println(s.charAt(index));
        }
    }
}
