import java.util.Scanner;

//  Write a Java program that takes a person's age as input and
//  categorizes them into one of three age categories: "Child,"
//  "Teenager," or "Adult" using an if statement.
//  use an if statement to categorize the age based on the following criteria:
//      • If the age is less than 13, categorize them as a "Child."
//      • If the age is between 13 and 19 (inclusive), categorize them as a "Teenager."
//      • If the age is 20 or older, categorize them as an "Adult."

public class Age {
    public static void main(String[] args) {

        // Input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        if (age < 13) {
            System.out.println("You are a Child.");
        } else if (age <= 19) { // no need for age >= 13 since it was checked in the previous if
            System.out.println("You are a Teenager");
        } else {
            System.out.println("You are an Adult");
        }
    }
}
