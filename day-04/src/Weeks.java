
//  7.Use a for loop to print headings for four weeks (Weeks 1 - 4). Then use
//  another for loop to print the days (Days 1 -7) for each week.
//  Expected Output:
//  Week 1
//      Day1
//      Day2
//      Day3
//      Day4
//      Day5
//      Day6
//      Day7
//  Week 2
//      Day1
//      Day2
//      ...

public class Weeks {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            System.out.println("Week " + i);

            for (int j = 1; j <= 7; j++) {
                System.out.println("\tDay " + j);
            }
        }
    }
}
