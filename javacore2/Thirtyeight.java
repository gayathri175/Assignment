package practice2;
import java.io.*;
import java.util.Scanner;

class EmployeeData implements Serializable {
    private static final long serialVersionUID = 1L;

    String emp_id;
    String emp_name;
    transient double emp_sal;  

    public EmployeeData(String emp_id, String emp_name, double emp_sal) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_sal = emp_sal;
    }

    public void display() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Employee Salary: " + emp_sal); 
    }
}

public class Thirtyeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
           
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();

           
            EmployeeData emp = new EmployeeData(id, name, salary);

           
            FileOutputStream fos = new FileOutputStream("employee.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);
            oos.close();
            fos.close();
            System.out.println("\nEmployee object serialized successfully.");

            
            FileInputStream fis = new FileInputStream("employee.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            EmployeeData deserializedEmp = (EmployeeData) ois.readObject();
            ois.close();
            fis.close();

           
            System.out.println("\nDeserialized Employee object:");
            deserializedEmp.display();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
/*Enter Employee ID: 890
Enter Employee Name: busrapau
Enter Employee Salary: 89999

Employee object serialized successfully.

Deserialized Employee object:
Employee ID: 890
Employee Name: busrapau
Employee Salary: 0.0
*/