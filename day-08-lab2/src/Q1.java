import java.util.ArrayList;

//  1.Write a program to find all of the longest word in a given dictionary.
//  Example:
//        { "cat", "dog", "red", "is", "am" } Expected
//  Output:
//        "cat", "dog", "red"


public class Q1 {
    public static void main(String[] args) {
        String[] words = { "cat", "dog", "red", "is", "am" };

        // Get the length of the longest words
        int longest = longestWordLength(words);

        ArrayList<String> longestWords = new ArrayList<String>();

        for (String word : words) {
            if (word.length() == longest) {
                longestWords.add(word);
            }
        }

        System.out.println(longestWords);

        // if you want identical output to the expected output we can just do it using print.
    }

    public static int longestWordLength(String[] words) {
        int longest = 0;
        for (String word : words) {
            if (word.length() > longest) {
                longest = word.length();
            }
        }
        return longest;
    }
}