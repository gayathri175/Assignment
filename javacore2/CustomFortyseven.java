package practice2;

class InvalidSalaryException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSalaryException(String message) {
        super(message);
    }
}

class firstEmployee {
    private String name;
    private double salary;

    public firstEmployee(int id, String name, double salary) {
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

class EmployeeService {
    public void validateSalary(double salary) throws InvalidSalaryException {
        if (salary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative.");
        }
    }

    public void processSalary(firstEmployee emp) throws InvalidSalaryException {
        validateSalary(emp.getSalary());
        System.out.println("Processing salary for: " + emp.getName());
    }

    public void startProcess(firstEmployee emp) throws InvalidSalaryException {
        processSalary(emp);
    }
}

public class CustomFortyseven {

    public static void main(String[] args) {
        firstEmployee emp = new firstEmployee(1, "Mushas", 50000);
        EmployeeService service = new EmployeeService();

        try {
            service.startProcess(emp);
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}