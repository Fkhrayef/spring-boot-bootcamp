
//  7. Write a program that checks the strength of a password. Create a method that evaluates a
//  password based on criteria like length, inclusion of special characters, and
//  uppercase/lowercase letters.
//      - We have three methods: checkLength, checkSpecialCharacters, and
//  checkUpperCaseLowerCase, each of which assigns a score based on specific criteria.
//      - The totalScore is calculated by adding the scores from these methods.
//      - Classify the password as strong (8 or more), moderately strong (5 or more), or weak
//  based on the totalScore. - The criteria for scoring:
//      • Length: 0-5 characters (0 points), 6-7 characters (2 points), 8 or more characters
//        (3 points).
//      • Special characters: Absence (0 points), Presence (2 points).
//      • Uppercase and lowercase letters: Absence of both (0 points), presence of both (3
//        points).
//  Example:
//  Enter a password: 3456 Expected Output:
//  Password is weak

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = sc.nextLine();

        int totalScore = 0;

        totalScore += checkLength(password);
        totalScore += checkSpecialCharacters(password);
        totalScore += checkUpperCaseLowerCase(password);

        if (totalScore >= 8) {
            System.out.println("Password is strong");
        } else if (totalScore >= 5) {
            System.out.println("Password is moderate");
        } else {
            System.out.println("Password is weak");
        }
    }

    public static int checkLength(String password) {
        if (password.length() >= 8) {
            System.out.println("3 points (length)");
            return 3;
        } else if (password.length() > 5) {
            System.out.println("2 points (length)");
            return 2;
        } else {
            System.out.println("0 points (length)");
            return 0;
        }
    }

    public static int checkSpecialCharacters(String password) {
        if (!password.matches("[A-Za-z0-9]+")) {
            System.out.println("2 points (special characters)");
            return 2;
        } else {
            System.out.println("0 points (special characters)");
            return 0;
        }
    }

    public static int checkUpperCaseLowerCase(String password) {

        // Using ASCII
//        int numOfCapitalLetters = 0;
//        int numOfSmallLetters = 0;
//
//        for (int i = 0; i < password.length(); i++) {
//            if(password.charAt(i) >= 65 && password.charAt(i) <= 90) {
//                numOfCapitalLetters++;
//            }
//            if(password.charAt(i) >= 97 && password.charAt(i) <= 122) {
//                numOfSmallLetters++;
//            }
//        }
//
//        if (numOfCapitalLetters == 0 && numOfSmallLetters == 0) {
//            System.out.println("0 points (UpperCaseLowerCase)");
//            return 0;
//        } else if(numOfCapitalLetters > 0 && numOfSmallLetters > 0) {
//            System.out.println("3 points (UpperCaseLowerCase)");
//            return 3;
//        } else {
//            System.out.println("0 points (UpperCaseLowerCase)");
//            return 0;
//        }

        // Using regex
        if(password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")) {
            System.out.println("3 points (UpperCaseLowerCase)");
            return 3;
        } else {
            System.out.println("0 points (UpperCaseLowerCase)");
            return 0;
        }


    }

}
