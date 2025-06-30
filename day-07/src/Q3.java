import java.util.Scanner;

//  3 - Write a Java method to check whether a string is a valid password.
//  Password rules:
//  A password must have at least eight characters. A
//  password consists of only letters and digits. A
//  password must contain at least two digits.
//  Expected Output:
//        1. A password must have at least eight characters.
//        2. A password consists of only letters and digits.
//        3. A password must contain at least two digits
//  Input a password (You are agreeing to the above Terms and
//        Conditions.):
//  abcd1234
//  Password is valid: abcd1234


public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printPasswordRules(); // A method to print the password rules.

        System.out.println("Input a password (You are agreeing to the above Terms and Conditions.):");
        String password = sc.nextLine();

        boolean isValid = validatePassword(password); // A method to validate passwords

        if (isValid) {
            System.out.println("Password is valid: " + password);
        }
    }

    // A method to print the password rules
    public static void printPasswordRules() {
        System.out.println("1. A password must have at least eight characters.\n" +
                "2. A password consists of only letters and digits.\n" +
                "3. A password must contain at least two digits\n");
    }

    // A method to validate passwords
    public static boolean validatePassword(String password) {

        // Assume all conditions are met!
        boolean[] conditions = {true, true, true};

        // First Condition
        if (password.length() < 8) {
            // the first condition failed
            conditions[0] = false;
        }

        // Second Condition
        if (!password.matches("[A-Za-z0-9]+")) {
            // the second condition failed
            conditions[1] = false;
        }

        // Third Condition
        int numOfDigits = countDigitsInString(password); // a method to count how many digits in the password

        if (numOfDigits < 2) {
            // the third condition failed
            conditions[2] = false;
        }

        // Print what's wrong
        printWhatsWrong(conditions); // a method to print all failed conditions reasons.

        // return true if the password is valid, or false if any condition failed (turned into false).
        return conditions[0] && conditions[1] && conditions[2];
    }

    // A method to count how many digits in a string.
    public static int countDigitsInString(String password) {
        int numOfDigits = 0;
        for (int i = 0; i < password.length(); i++) {

            // Count how many digits in a password
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                numOfDigits++;
            }
        }

        return numOfDigits;
    }

    // A method to print failed conditions reasons.
    public static void printWhatsWrong(boolean[] conditions) {

        if (!conditions[0]) {
            System.out.println("Password must be at least 8 characters.");
        }
        if (!conditions[1]) {
            System.out.println("Password must only consist of alphanumeric characters.");
        }
        if (!conditions[2]) {
            System.out.println("Password must contain at least two digits.");
        }

    }
}
