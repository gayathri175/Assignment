package practice1;
import java.util.Scanner;

public class StudentAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalMarks = 0;
        int mark;
        int studentCount = 3;

        for (int i = 1; i <= studentCount; i++) {
            while (true) {
                System.out.print("Enter the mark (0-100) for student " + i + ": ");
                mark = input.nextInt();

                if (mark >= 0 && mark <= 100) {
                    totalMarks += mark;
                    break;
                } else {
                    System.out.println("Invalid input, try again...");
                }
            }
        }

        double average = totalMarks / (double) studentCount;
        System.out.println("The average is: " + String.format("%.2f", average));

        input.close();
    }
}
/*Enter the mark (0-100) for student 1: 88
Enter the mark (0-100) for student 2: 89
Enter the mark (0-100) for student 3: 92
The average is: 89.67*/
