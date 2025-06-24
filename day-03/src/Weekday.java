import java.util.Scanner;

//  3.Write a Java program that generates an integer between 1 and 7
//  and displays the name of the weekday.

public class Weekday {
    public static void main(String[] args) {

        // Generate a random number (1-7) (this is how I understood the problem)
        int num = (int) ((Math.random() * 7) + 1);

        // Input the num from user (this is what's shown in test data)
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter a number between 1 and 7: ");
//        int num = sc.nextInt();

        // Match the generated number with a weekday (starting from sunday as 1)
        switch (num) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid input");
        }
    }
}
