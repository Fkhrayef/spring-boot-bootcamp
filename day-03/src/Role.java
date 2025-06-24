import java.util.Scanner;

//  1.Write a program that checks the role of the user

public class Role {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Here I assumed the role is given as input from the user
        System.out.print("Enter your role: ");
        String role = sc.nextLine();

        if (role.equalsIgnoreCase("admin")) {
            System.out.println("welcome admin");
        } else if (role.equalsIgnoreCase("supervisor")) {
            System.out.println("welcome supervisor");
        } else if (role.equalsIgnoreCase("user")) {
            System.out.println("welcome user");
        } else {
            System.out.println("Invalid role");
        }
    }
}