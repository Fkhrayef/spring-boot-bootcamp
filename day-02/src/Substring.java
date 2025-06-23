import java.util.Scanner;

//  5. Develop a program that takes a sentence as input and extracts a substring from
//  it, then prints the extracted substring.
//      • Input: Sentence = "The quick brown fox jumps over the lazy dog", Start Index
//        = 10, End Index = 20
//      • Expected Output: "brown fox"

public class Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("Enter a sentence: ");
        String string = sc.nextLine();

        System.out.print("Enter Start Index: ");
        int startIndex = sc.nextInt();

        System.out.print("Enter End Index: ");
        int endIndex = sc.nextInt();

        // Calculation
        string = string.substring(startIndex, endIndex);

        // Output
        System.out.println(string);
    }
}
