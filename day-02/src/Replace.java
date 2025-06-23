import java.util.Scanner;

//  7. Develop a program that takes a sentence and a word to replace as input, then
//  replace all occurrences of the word with another word and prints the modified
//  sentence.
//      • Input: Sentence = "The quick brown fox jumps over the lazy dog", Word to
//        Replace = "fox", Replacement Word = "cat"
//      • Expected Output: "The quick brown cat jumps over the lazy dog"

public class Replace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("Enter a sentence: ");
        String string = sc.nextLine();

        System.out.print("Enter a word to replace: ");
        String wordToReplace = sc.nextLine();

        System.out.print("Enter the replacement word: ");
        String replacement = sc.nextLine();

        // Calculations
        string = string.replace(wordToReplace, replacement);

        // Output
        System.out.println("Sentence after replacement: " + string);
    }
}
