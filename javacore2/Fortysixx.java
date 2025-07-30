package practice2;
import java.util.*;


class Repository<T, ID> {
 private Map<ID, T> storage = new HashMap<>();

 public void save(ID id, T entity) {
     storage.put(id, entity);
 }

 public T findById(ID id) {
     return storage.get(id);
 }

 public List<T> findAll() {
     return new ArrayList<>(storage.values());
 }

 public void deleteById(ID id) {
     storage.remove(id);
 }
}


class EmployeeRecord {
 int id;
 String name;
 double salary;

 public EmployeeRecord(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }

 @Override
 public String toString() {
     return "Employee { ID=" + id + ", Name=" + name + ", Salary=" + salary + " }";
 }
}

public class Fortysixx {
 public static void main(String[] args) {
     Repository<EmployeeRecord, Integer> repo = new Repository<>();
     Scanner sc = new Scanner(System.in);

     
     for (int i = 1; i <= 3; i++) {
         System.out.println("Enter details for Employee " + i + ":");
         System.out.print("ID: ");
         int id = sc.nextInt();
         sc.nextLine(); // consume newline

         System.out.print("Name: ");
         String name = sc.nextLine();

         System.out.print("Salary: ");
         double salary = sc.nextDouble();

         EmployeeRecord emp = new EmployeeRecord(id, name, salary);
         repo.save(id, emp);
     }

     // Display all employees
     System.out.println("\nAll Employees:");
     for (EmployeeRecord emp : repo.findAll()) {
         System.out.println(emp);
     }

     
     System.out.print("\nEnter ID to search: ");
     int searchId = sc.nextInt();
     EmployeeRecord found = repo.findById(searchId);
     if (found != null) {
         System.out.println("Found: " + found);
     } else {
         System.out.println("Employee not found.");
     }

     
     System.out.print("\nEnter ID to delete: ");
     int deleteId = sc.nextInt();
     repo.deleteById(deleteId);

     System.out.println("\nEmployees after deletion:");
     for (EmployeeRecord emp : repo.findAll()) {
         System.out.println(emp);
     }

     sc.close();
 }
}
/*Enter details for Employee 1:
ID: 891
Name: busarapu
Salary: 78999
Enter details for Employee 2:
ID: 645
Name: honey
Salary: 45666
Enter details for Employee 3:
ID: 789
Name: srinu
Salary: 65888

All Employees:
Employee { ID=645, Name=honey, Salary=45666.0 }
Employee { ID=789, Name=srinu, Salary=65888.0 }
Employee { ID=891, Name=busarapu, Salary=78999.0 }

Enter ID to search:: 891
Found: Employee { ID=891, Name=busarapu, Salary=78999.0 }

Enter ID to delete: 645

Employees after deletion:
Employee { ID=789, Name=srinu, Salary=65888.0 }
Employee { ID=891, Name=busarapu, Salary=78999.0 }
*/ 