package practice1;

import java.util.Scanner;

public class AttendenceCheckSeven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter number of classes held: ");
        int totalClasses = input.nextInt();

        System.out.print("Enter number of classes attended: ");
        int attendedClasses = input.nextInt();

        
        double percentage = (attendedClasses * 100.0) / totalClasses;
        System.out.println("Your attendance percentage is: " + percentage + "%");
        if (percentage < 70) {
            System.out.println("You are NOT allowed to sit in the exam.");
        } else {
            System.out.println("You are allowed to sit in the exam.");
        }

        input.close(); 
    }
}

 /*Enter number of classes held: 6
Enter number of classes attended: 5
Your attendance percentage is: 83.33333333333333%
You are allowed to sit in the exam.
*/      
        

        
       
