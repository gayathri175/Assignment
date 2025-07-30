package practice2;
import java.util.Scanner;

@SuppressWarnings("serial")

class InvalidEmployeeCode extends Exception {
 public InvalidEmployeeCode(String message) {
     super(message);
 }
}


class EmployeeDetails {
 private String empCode;
 private String name;
 private int yearOfBirth;

 public EmployeeDetails(String empCode, String name, int yearOfBirth) {
     this.empCode = empCode;
     this.name = name;
     this.yearOfBirth = yearOfBirth;
 }

 public void displayDetails() {
     System.out.println("\nEmployee Details:");
     System.out.println("Employee Code: " + empCode);
     System.out.println("Name: " + name);
     System.out.println("Year of Birth: " + yearOfBirth);
 }
}

public class EmployeeValidationThirtyfive {
 // Validate Employee Code format: YY-D-NNN
 public static void validateEmployeeCode(String code) throws InvalidEmployeeCode {
     String regex = "\\d{2}-[FS]-\\d{3}"; 
     if (!code.matches(regex)) {
         throw new InvalidEmployeeCode("Invalid Employee Code: " + code);
     }
 }

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     try {
         // Read input
         System.out.print("Enter Employee Code (format: YY-D-NNN): ");
         String code = sc.nextLine();

         System.out.print("Enter Employee Name: ");
         String name = sc.nextLine();

         System.out.print("Enter Year of Birth: ");
         int year = sc.nextInt();

         // Validate employee code
         validateEmployeeCode(code);

         
         EmployeeDetails emp = new EmployeeDetails(code, name, year);
         emp.displayDetails();

     } catch (InvalidEmployeeCode e) {
         System.out.println("Error: " + e.getMessage());
     } catch (Exception e) {
         System.out.println("Unexpected error: " + e.getMessage());
     } finally {
         sc.close();
     }
 }
}
/*Enter Employee ID: 891
Enter Employee Name: gayathri
Enter Designation (Manager / TeamLeader / HR): hr
Enter Basic Salary: 89999
Employee Details:
Emp ID: 891
Name: gayathri
Designation: hr
Basic Salary: 89999.0
HRA: 4499.95
*/
