import java.util.InputMismatchException;
import java.util.Scanner;

//  18 - Determine and print the number of times the character ‘a’ appears in the input
//  entered by the user.
//  Enter String:
//  Java bootcamp
//  Output: Number of a's: 3

public class Q18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter a string: ");
            String s = sc.nextLine();

            int numOfa = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a') numOfa++;
            }

            System.out.println("Number of a's: " + numOfa);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }
}
