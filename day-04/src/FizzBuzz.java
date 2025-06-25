
//  1. Write a program that prints the numbers from 1 to 100 such that:
//  If the number is a multiple of 3, you need to print "Fizz" instead of that
//  number.
//  If the number is a multiple of 5, you need to print "Buzz" instead of that
//  number.
//  If the number is a multiple of both 3 and 5, you need to print "FizzBuzz"
//  instead of that number.

public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

        // while this is the requirement, if we want to generalize it we could easily
        // let the user input the stop number (hardcoded 100 in our case)
    }
}