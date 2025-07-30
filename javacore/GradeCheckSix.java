package practice1;
import java.util.Scanner;

public class GradeCheckSix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  //inputt

        System.out.print("Enter your marks (0 to 100): ");
        int marks = input.nextInt();  

        
        if (marks < 25) {
            System.out.println("Your Grade is: F");
        } else if (marks <= 45) {
            System.out.println("Your Grade is: E");
        } else if (marks <= 50) {
            System.out.println("Your Grade is: D");
        } else if (marks <= 60) {
            System.out.println("Your Grade is: C");
        } else if (marks <= 80) {
            System.out.println("Your Grade is: B");
        } else {
            System.out.println("Your Grade is: A");
        }

        input.close();  
    }
}
/*Enter your marks (0 to 100): 98
Your Grade is: A
*/

