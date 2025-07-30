package practice2;

import java.util.regex.*;

class Employee {
    private String employeeId;
    private String name;
    private int yearOfBirth;

    
    public Employee(String employeeId, String name, int yearOfBirth) {
        if (validateEmployeeId(employeeId)) {
            this.employeeId = employeeId;
        } else {
            throw new IllegalArgumentException("Invalid Employee ID format");
        }
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    
    private boolean validateEmployeeId(String id) {
        String regex = "\\d{2}-[FS]-\\d{3}";  
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    // Display details
    public void displayEmployeeDetails() {
        System.out.println("Employee Details:");
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yearOfBirth);
    }

    
    public static void main(String[] args) {
        try {
            Employee e1 = new Employee("81-F-112", "Gayathribusarapu", 1981);
            e1.displayEmployeeDetails();

            System.out.println();

            Employee e2 = new Employee("79-S-254", "honey", 1979);
            e2.displayEmployeeDetails();

            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
