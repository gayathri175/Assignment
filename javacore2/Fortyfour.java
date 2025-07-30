package practice2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MyEmployee {
	int id;
	String name;
	double salary;

	public MyEmployee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
	}
}

public class Fortyfour {

	public static void main(String[] args) {
		List<MyEmployee> employees = new ArrayList<>();
		employees.add(new MyEmployee(101, "Gayathri", 55000));
		employees.add(new MyEmployee(102, "Prudhvy", 72000));
		employees.add(new MyEmployee(103, "Sripriya", 48000));
		employees.add(new MyEmployee(104, "Rohith", 72000));
		employees.add(new MyEmployee(105, "Spruthvi", 60000));

		Collections.sort(employees, new Comparator<MyEmployee>() {
			public int compare(MyEmployee e1, MyEmployee e2) {
				return Double.compare(e2.salary, e1.salary);
			}
		});

		System.out.println("Sorted by Salary (Descending):");
		for (MyEmployee emp : employees) {
			System.out.println(emp);
		}

		Collections.sort(employees, (e1, e2) -> e1.name.compareToIgnoreCase(e2.name));

		System.out.println("\nSorted by Name (Alphabetically):");
		for (MyEmployee emp : employees) {
			System.out.println(emp);
		}
	}
}
/*Sorted by Salary (Descending):
ID: 102, Name: Prudhvy, Salary: 72000.0
ID: 104, Name: Rohith, Salary: 72000.0
ID: 105, Name: Spruthvi, Salary: 60000.0
ID: 101, Name: Gayathri, Salary: 55000.0
ID: 103, Name: Sripriya, Salary: 48000.0

Sorted by Name (Alphabetically):
ID: 101, Name: Gayathri, Salary: 55000.0
ID: 102, Name: Prudhvy, Salary: 72000.0
ID: 104, Name: Rohith, Salary: 72000.0
ID: 105, Name: Spruthvi, Salary: 60000.0
ID: 103, Name: Sripriya, Salary: 48000.0
*/