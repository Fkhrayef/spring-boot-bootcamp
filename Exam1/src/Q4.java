
// 4. Write a Java program to find positive and negative
// numbers of a given array:

//  Original Array:
//  [10, -21 , 30, 31, -25]
//  Expected Output:
//      10  is a positive number
//     -21 is a negative number
//      30 is a positive number
//      31 is a positive number
//     -25 is a negative number



public class Q4 {
    public static void main(String[] args) {
        int[] array = {10, -21 , 30, 31, -25};

        for (int num : array) {
            if (num > 0) {
                System.out.println(num + " is a positive number");
            } else if (num < 0) {
                System.out.println(num + " is a negative number");
            } else {
                // we can disregard this if the array is constant
                // (by removing the -else if- condition and turning
                // this Sout to print negative numbers.
                System.out.println(num + " is a zero");
            }
        }
    }
}
