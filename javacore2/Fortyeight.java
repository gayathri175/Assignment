package practice2;

@FunctionalInterface
interface EmployeeProcessor {
    void process(Employee48 e);
}

class Employee48 {
    private String name;
    private double salary;

    public Employee48(int id, String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}

public class Fortyeight {

    public static void main(String[] args) {
        Employee48 emp = new Employee48(1, "Gayathri", 90000);

        EmployeeProcessor printDetails = (e) -> {
            System.out.println("Employee Name: " + e.getName());
            System.out.println("Employee Salary: " + e.getSalary());
        };

        EmployeeProcessor calculateBonus = (e) -> {
            double bonus = e.getSalary() * 0.10;
            System.out.println("Bonus (10%): " + bonus);
        };

        printDetails.process(emp);
        calculateBonus.process(emp);
    }
}
/*Employee Name: Gayathri
Employee Salary: 90000.0
Bonus (10%): 9000.0
*/
