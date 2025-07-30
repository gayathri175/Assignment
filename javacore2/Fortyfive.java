package practice2;


import java.util.*;
import java.util.stream.Collectors;

class Student {
	int id;
	String name;
	String department;

	public Student(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public String getName() {
		return name;
	}
}

public class Fortyfive {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Gayathri", "CSE"));
		students.add(new Student(2, "Prudhvy", "Civil"));
		students.add(new Student(3, "Vathsalya", "CSE"));
		students.add(new Student(4, "NandiniP", "EEE"));
		students.add(new Student(5, "Mukesh", "ECE"));

		Map<String, List<Student>> groupedByDept = students.stream()
				.collect(Collectors.groupingBy(Student::getDepartment));

		for (Map.Entry<String, List<Student>> entry : groupedByDept.entrySet()) {
			System.out.println("Department: " + entry.getKey());
			for (Student s : entry.getValue()) {
				System.out.println("- " + s.getName());
			}
		}
	}
}
/*Department: Civil
- Prudhvy
Department: EEE
- NandiniP
Department: CSE
- Gayathri
- Vathsalya
Department: ECE
- Mukesh
*/