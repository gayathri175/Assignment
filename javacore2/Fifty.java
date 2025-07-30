package practice2;


import java.util.*;

import java.util.stream.Collectors;

public class Fifty {

    public static void main(String[] args) {

        List<Employee50> employees = Arrays.asList(
                new Employee50(101, "gayathri", "HR", 50000),
                new Employee50(102, "busarapu", "IT", 60000),
                new Employee50(103, "ghaffar", "HR", 55000),
                new Employee50(104, "ranjith", "IT", 70000),
                new Employee50(105, "vishwas", "Sales", 45000)
        );

        // Q1
        System.out.println("Q1:");
        employees.stream().map(Employee50::getName).forEach(System.out::println);

        // Q2
        System.out.println("\nQ2:");
        employees.stream().filter(e -> e.getSalary() > 55000).forEach(System.out::println);

        // Q3
        System.out.println("\nQ3:");
        long hrCount = employees.stream().filter(e -> e.getDepartment().equals("HR")).count();
        System.out.println("HR count: " + hrCount);

        // Q4
        System.out.println("\nQ4:");
        employees.stream().sorted(Comparator.comparingDouble(Employee50::getSalary).reversed()).forEach(System.out::println);

        // Q5
        System.out.println("\nQ5:");
        employees.stream().max(Comparator.comparingDouble(Employee50::getSalary)).ifPresent(System.out::println);

        // Q6
        System.out.println("\nQ6:");
        double avgSalary = employees.stream().mapToDouble(Employee50::getSalary).average().orElse(0);
        System.out.println("Average Salary: " + avgSalary);

        // Q7
        System.out.println("\nQ7:");
        List<String> names = employees.stream().map(Employee50::getName).collect(Collectors.toList());
        System.out.println(names);

        // Q8
        System.out.println("\nQ8:");
        Map<String, List<Employee50>> byDept = employees.stream().collect(Collectors.groupingBy(Employee50::getDepartment));
        byDept.forEach((dept, list) -> System.out.println(dept + ": " + list));

        // Q9
        System.out.println("\nQ9:");
        Map<String, Double> totalSalaryPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee50::getDepartment, Collectors.summingDouble(Employee50::getSalary)));
        System.out.println(totalSalaryPerDept);

        // Q10
        System.out.println("\nQ10:");
        employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .sorted(Comparator.comparingDouble(Employee50::getSalary))
                .map(Employee50::getName)
                .forEach(System.out::println);

        // Q11
        System.out.println("\nQ11:");
        boolean anyLowSalary = employees.stream().anyMatch(e -> e.getSalary() < 40000);
        System.out.println("Any salary < 40000? " + anyLowSalary);

        // Q12
        System.out.println("\nQ12:");
        String commaSeparated = employees.stream().map(Employee50::getName).collect(Collectors.joining(", "));
        System.out.println(commaSeparated);

        // Q13
        System.out.println("\nQ13:");
        List<Employee50> top2 = employees.stream()
                .sorted(Comparator.comparingDouble(Employee50::getSalary).reversed())
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(top2);

        // Q14
        System.out.println("\nQ14:");
        employees.stream().skip(2).forEach(System.out::println);

        // Q15
        System.out.println("\nQ15:");
        employees.stream().limit(3).map(Employee50::getName).forEach(System.out::println);

        // Q16
        System.out.println("\nQ16:");
        employees.stream()
                .filter(e -> e.getDepartment().equals("HR"))
                .min(Comparator.comparingDouble(Employee50::getSalary))
                .ifPresent(System.out::println);

        // Q17
        System.out.println("\nQ17:");
        Map<Boolean, List<Employee50>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 55000));
        System.out.println("Salary > 55000: " + partitioned.get(true));
        System.out.println("Salary <= 55000: " + partitioned.get(false));

        // Q18
        System.out.println("\nQ18:");
        Map<String, Double> avgSalaryPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee50::getDepartment, Collectors.averagingDouble(Employee50::getSalary)));
        System.out.println(avgSalaryPerDept);

        // Q19
        System.out.println("\nQ19:");
        employees.stream()
                .sorted(Comparator.comparing(Employee50::getName).thenComparing(Employee50::getSalary))
                .forEach(System.out::println);

        // Q20
        System.out.println("\nQ20:");
        Map<Integer, String> idNameMap = employees.stream()
                .collect(Collectors.toMap(Employee50::getId, Employee50::getName));
        System.out.println(idNameMap);

        // 🔹 Challenge 1
        System.out.println("\nChallenge 1:");
        employees.stream()
                .filter(e -> e.getName().startsWith("D") && e.getName().endsWith("a"))
                .forEach(System.out::println);

        // 🔹 Challenge 2
        System.out.println("\nChallenge 2:");
        byDept.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> System.out.println(entry.getKey()));

        // 🔹 Challenge 3
        System.out.println("\nChallenge 3:");
        employees.stream()
                .map(Employee50::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(sal -> System.out.println("Second Highest Salary: " + sal));
    }
}

class Employee50 {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee50(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getDepartment() { return department; }

    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' +
                ", department='" + department + '\'' + ", salary=" + salary + '}';
    }
}
/*Q1:
gayathri
busarapu
ghaffar
ranjith
vishwas

Q2:
Employee{id=102, name='busarapu', department='IT', salary=60000.0}
Employee{id=104, name='ranjith', department='IT', salary=70000.0}

Q3:
HR count: 2

Q4:
Employee{id=104, name='ranjith', department='IT', salary=70000.0}
Employee{id=102, name='busarapu', department='IT', salary=60000.0}
Employee{id=103, name='ghaffar', department='HR', salary=55000.0}
Employee{id=101, name='gayathri', department='HR', salary=50000.0}
Employee{id=105, name='vishwas', department='Sales', salary=45000.0}

Q5:
Employee{id=104, name='ranjith', department='IT', salary=70000.0}

Q6:
Average Salary: 56000.0

Q7:
[gayathri, busarapu, ghaffar, ranjith, vishwas]

Q8:
Sales: [Employee{id=105, name='vishwas', department='Sales', salary=45000.0}]
HR: [Employee{id=101, name='gayathri', department='HR', salary=50000.0}, Employee{id=103, name='ghaffar', department='HR', salary=55000.0}]
IT: [Employee{id=102, name='busarapu', department='IT', salary=60000.0}, Employee{id=104, name='ranjith', department='IT', salary=70000.0}]

Q9:
{Sales=45000.0, HR=105000.0, IT=130000.0}

Q10:
busarapu
ranjith

Q11:
Any salary < 40000? false

Q12:
gayathri, busarapu, ghaffar, ranjith, vishwas

Q13:
[Employee{id=104, name='ranjith', department='IT', salary=70000.0}, Employee{id=102, name='busarapu', department='IT', salary=60000.0}]

Q14:
Employee{id=103, name='ghaffar', department='HR', salary=55000.0}
Employee{id=104, name='ranjith', department='IT', salary=70000.0}
Employee{id=105, name='vishwas', department='Sales', salary=45000.0}

Q15:
gayathri
busarapu
ghaffar

Q16:
Employee{id=101, name='gayathri', department='HR', salary=50000.0}

Q17:
Salary > 55000: [Employee{id=102, name='busarapu', department='IT', salary=60000.0}, Employee{id=104, name='ranjith', department='IT', salary=70000.0}]
Salary <= 55000: [Employee{id=101, name='gayathri', department='HR', salary=50000.0}, Employee{id=103, name='ghaffar', department='HR', salary=55000.0}, Employee{id=105, name='vishwas', department='Sales', salary=45000.0}]

Q18:
{Sales=45000.0, HR=52500.0, IT=65000.0}

Q19:
Employee{id=102, name='busarapu', department='IT', salary=60000.0}
Employee{id=101, name='gayathri', department='HR', salary=50000.0}
Employee{id=103, name='ghaffar', department='HR', salary=55000.0}
Employee{id=104, name='ranjith', department='IT', salary=70000.0}
Employee{id=105, name='vishwas', department='Sales', salary=45000.0}

Q20:
{101=gayathri, 102=busarapu, 103=ghaffar, 104=ranjith, 105=vishwas}

Challenge 1:

Challenge 2:
HR
IT

Challenge 3:
Second Highest Salary: 60000.0
*/