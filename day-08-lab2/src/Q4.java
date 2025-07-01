
//  4. Create a method to reverse an array of integers. Implement the method without creating a new
//  array.
//  Original Array:
//        [5,4,3,2,1] Expected Output:
//  Reversed Array:
//        1 2 3 4 5

public class Q4 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        System.out.println("Reversed Array: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
