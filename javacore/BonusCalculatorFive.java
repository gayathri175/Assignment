package practice1;
import java.util.Scanner; 

public class BonusCalculatorFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //here creating scanner object
        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble(); //primitive type double
        System.out.print("Enter your years of service: ");
        int years = sc.nextInt(); 
         

        if (years > 6) {
            double bonus = salary * 10/100; // 10% bonus given in qstn
            
            System.out.println("Your bonus amount is: rupees" + bonus);
        } else {
            System.out.println("Sorry, you are not eligible for bonus.");
        }

        sc.close(); 
    }
}
/*Enter your salary: 50000
Enter your years of service: 3
Sorry, you are not eligible for bonus.*/
