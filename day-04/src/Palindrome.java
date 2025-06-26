import java.util.Scanner;

//  8.Write a program that check if the word is a palindrome or not. hint: A
//  string is said to be a palindrome if it is the same if we start reading it from
//  left to right or right to left.

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter a word: ");
        String string = sc.nextLine().trim(); // take the word and trim whitespace if available

        // Reverse the string (I don't have to use loop like in the Reverse question)
        StringBuilder reversed = new StringBuilder(string);
        reversed.reverse();

        // Check if the original string equals the reversed string
        if (string.equalsIgnoreCase(reversed.toString())) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}


// alternative sol using loops:
//  Scanner sc = new Scanner(System.in);
//
//  // Input
//  System.out.println("Enter a word: ");
//  String string = sc.nextLine().trim();
//
//  boolean isPalindrome = true;
//
//  // two pointers, 1 start from the beginning and the other starts from the end,
//  // and we compare them until we reach the middle
//  for (int i = 0; i < string.length() / 2; i++) {
//      char start = Character.toLowerCase(string.charAt(i));
//      char end = Character.toLowerCase(string.charAt(string.length() - 1 - i));
//
//      if (start != end) {
//          isPalindrome = false;
//        break;
//        }
//      }
//
//  if (isPalindrome) {
//      System.out.println("Palindrome");
//  } else {
//      System.out.println("Not a palindrome");
//  }