package practice2;
import java.util.*;

//Custom Exception for Low Salary
class LowSalException extends Exception {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 public LowSalException(String message) {
     super(message);
 }
}

//Emp Class
class Emp {
 private int empId;
 private String empName;
 private String designation;
 private double basic;
 private double hra; // read-only

 // Constructor
 public Emp(int empId, String empName, String designation, double basic) throws LowSalException {
     if (basic < 50000) {
         throw new LowSalException("Basic salary cannot be less than 50000.");
     }
     this.empId = empId;
     this.empName = empName;
     this.designation = designation;
     this.basic = basic;
     calculateHRA();
 }

 // Calculate HRA based on designation
 private void calculateHRA() {
     if (designation.equalsIgnoreCase("Manager")) {
         hra = 0.10 * basic;
     } else if (designation.equalsIgnoreCase("TeamLeader")) {
         hra = 0.12 * basic;
     } else if (designation.equalsIgnoreCase("HR")) {
         hra = 0.05 * basic;
     } else {
         hra = 0; // default if designation not matched
     }
 }

 // Print Employee Details
 public void printDET() {
     System.out.println("Employee Details:");
     System.out.println("Emp ID: " + empId);
     System.out.println("Name: " + empName);
     System.out.println("Designation: " + designation);
     System.out.println("Basic Salary: " + basic);
     System.out.println("HRA: " + hra);
 }
}

public class EmployeedemoThirtythree {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     try {
         // Take employee details from user
         System.out.print("Enter Employee ID: ");
         int id = sc.nextInt();
         sc.nextLine(); // consume newline

         System.out.print("Enter Employee Name: ");
         String name = sc.nextLine();

         System.out.print("Enter Designation (Manager / TeamLeader / HR): ");
         String designation = sc.nextLine();

         System.out.print("Enter Basic Salary: ");
         double basic = sc.nextDouble();

         // Create Emp object
         Emp emp = new Emp(id, name, designation, basic);

         // Display details
         emp.printDET();

     } catch (LowSalException e) {
         System.out.println("Error: " + e.getMessage());
     } catch (Exception e) {
         System.out.println("Unexpected Error: " + e.getMessage());
     } finally {
         sc.close();
     }
 }
}
/*Enter Employee ID: 891
Enter Employee Name: gayathri
Enter Designation (Manager / TeamLeader / HR): hr
Enter Basic Salary: 79999
Employee Details:
Emp ID: 891
Name: gayathri
Designation: hr
Basic Salary: 79999.0
HRA: 3999.9500000000003
*/