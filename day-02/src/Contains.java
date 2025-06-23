import java.util.Scanner;

//  6. Write a program that takes a sentence and a keyword as input, then check if
//  the keyword is present in the sentence and prints the result.
//      • Input: Sentence = "The quick brown fox jumps over the lazy dog", Keyword =
//        "jumps"
//      • Expected Output: Keyword "jumps" is present in the sentence.

public class Contains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String string = sc.nextLine();

        System.out.print("Enter a keyword: ");
        String keyword = sc.nextLine();

        // Calculations
        boolean contains = string.contains(keyword);

        // output ( NOTE: Couldn't customize the output because I can't use conditions! )
        System.out.println("Keyword \"" + keyword + "\" present? " + contains);
    }
}
