package practice2;
import java.io.*;
import java.util.Scanner;

class EmployeeSerializable implements Serializable {
    private static final long serialVersionUID = 1L; 

    String emp_id;
    String emp_name;
    transient double emp_sal; 

    public EmployeeSerializable(String emp_id, String emp_name, double emp_sal) {
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

public class EmpThirtyeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
           
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();

            
            EmployeeSerializable emp = new EmployeeSerializable(id, name, salary);

            
            FileOutputStream fos = new FileOutputStream("employee.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);
            oos.close();
            fos.close();
            System.out.println("\nEmployee object serialized successfully.\n");

            
            FileInputStream fis = new FileInputStream("employee.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            EmployeeSerializable deserializedEmp = (EmployeeSerializable) ois.readObject();
            ois.close();
            fis.close();

            System.out.println("Deserialized Employee object:");
            deserializedEmp.display(); 

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
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