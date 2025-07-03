
// 5. Write a Java program to find a shortest word of a given array:
//  Original Array:
//    ["Tuwaiq", "Bootcamp" , "Student", "JAVA"]
//  Expected Output:
//     JAVA

public class Q5 {
    public static void main(String[] args) {
        String[] s = {"Tuwaiq", "Bootcamp", "Student", "JAVA"};

        String shortest = s[0];

        for (String string : s) {
            if (string.length() < shortest.length()) {
                shortest = string;
            }
        }

        System.out.println("Shortest word is: " + shortest);
    }
}
