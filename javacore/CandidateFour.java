package practice1;
import java.util.Scanner;  //we use scanner tool coz java  doesn’t take user input automatically

public class CandidateFour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
//it used to take the input from system
        
        System.out.println("Enter your name: ");// Taking inputs from user everytym
        String  name = input.nextLine();  

        System.out.println("Enter your roll number: "); 
        String rollNumber = input.nextLine();

        System.out.println("Enter your field of interest: ");
        String field = input.nextLine();
        System.out.println("Hey, my name is " + name + " and my roll number is " + rollNumber + ". My field of interest are " + field + ".");

        input.close();
    }
}

/*Enter your name: 
gayathri busarapu
Enter your roll number: 
327013
Enter your field of interest: 
scrolling instagram
Hey, my name is gayathri busarapu and my roll number is 327013. My field of interest are scrolling instagram.
*/


