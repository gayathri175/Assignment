package practice2;

import java.util.Optional;

public class Fortynine {

    public static void main(String[] args) {
        Employee49 emp1 = new Employee49("Gayathribusarapu", Optional.of("gayathri@example.com"), Optional.of("HR"));
        Employee49 emp2 = new Employee49("honey", Optional.empty(), Optional.empty());

        displayEmployeeDetails(emp1);
        displayEmployeeDetails(emp2);
    }

    static void displayEmployeeDetails(Employee49 emp) {
        System.out.println("Name: " + emp.getName());

        String email = emp.getEmail().orElse("No Email Provided");
        String department = emp.getDepartment().orElse("No Department Assigned");

        System.out.println("Email: " + email);
        System.out.println("Department: " + department);

        try {
            checkMandatoryFields(emp);
        } catch (MissingFieldException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("-------------");
    }

    static void checkMandatoryFields(Employee49 emp) throws MissingFieldException {
        if (emp.getEmail().isEmpty()) {
            throw new MissingFieldException("Email is mandatory but missing.");
        }
        if (emp.getDepartment().isEmpty()) {
            throw new MissingFieldException("Department is mandatory but missing.");
        }
    }
}

class Employee49 {
    private String name;
    private Optional<String> email;
    private Optional<String> department;

    public Employee49(String name, Optional<String> email, Optional<String> department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public Optional<String> getDepartment() {
        return department;
    }
}

class MissingFieldException extends Exception {
    private static final long serialVersionUID = 1L; // Added to avoid warning

    public MissingFieldException(String message) {
        super(message);
    }
}
/*Name: Gayathribusarapu
Email: gayathri@example.com
Department: HR
-------------
Name: honey
Email: No Email Provided
Department: No Department Assigned
Exception: Email is mandatory but missing.
-------------
*/