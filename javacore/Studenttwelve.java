package practice1;



import java.util.*;

class StudentQNO12 {
    private static int rollCounter = 1;
    private int rollNo;
    private String studName;
    private int marksInEng;
    private int marksInMaths;
    private int marksInScience;

    public StudentQNO12(String studName, int eng, int maths, int science) {
        this.rollNo = rollCounter++;
        this.studName = studName;
        this.marksInEng = eng;
        this.marksInMaths = maths;
        this.marksInScience = science;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getStudName() {
        return studName;
    }

    public int getMarksInEng() {
        return marksInEng;
    }

    public int getMarksInMaths() {
        return marksInMaths;
    }

    public int getMarksInScience() {
        return marksInScience;
    }

    public int getTotalMarks() {
        return marksInEng + marksInMaths + marksInScience;
    }

    public double getPercentage() {
        return getTotalMarks() / 3.0;
    }
}

class Standard {
    List<StudentQNO12> students;

    public Standard() {
        students = new ArrayList<>();

        students.add(new StudentQNO12("gayathri", 95, 90, 98));
        students.add(new StudentQNO12("prudhvy", 98, 82, 80));
        students.add(new StudentQNO12("vathsalya", 80, 75, 92));
        students.add(new StudentQNO12("Pnandini", 70, 95, 82));
        students.add(new StudentQNO12("mukesh", 78, 84, 80));
        students.add(new StudentQNO12("skona", 82, 87, 95));
        students.add(new StudentQNO12("kannayya", 76, 89, 91));
        students.add(new StudentQNO12("pandu", 84, 80, 86));
    }

    // 1. Ascending order by roll no
    public void displayStudentsByRollNo() {
        System.out.println("Students by Roll No:");
        students.stream()
                .sorted(Comparator.comparingInt(StudentQNO12::getRollNo))
                .forEach(s -> System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName()));
    }

    // 2. Highest percentage
    public void displayTopperByPercentage() {
        StudentQNO12 topper = students.stream()
                .max(Comparator.comparingDouble(StudentQNO12::getPercentage))
                .orElse(null);

        if (topper != null) {
            System.out.println("\nTopper by Percentage:");
            System.out.println("Roll No: " + topper.getRollNo() + ", Name: " + topper.getStudName());
        }
    }

    // 3. Highest marks in Mathematics
    public void displayTopperByMaths() {
        StudentQNO12 mathTopper = students.stream()
                .max(Comparator.comparingInt(StudentQNO12::getMarksInMaths))
                .orElse(null);

        if (mathTopper != null) {
            System.out.println("\nTopper in Mathematics:");
            System.out.println("Roll No: " + mathTopper.getRollNo() + ", Name: " + mathTopper.getStudName());
        }
    }

    // 4. Ascending by total of Maths + Science
    public void displayByMathsAndScienceTotal() {
        System.out.println("\nStudents by Maths + Science Total:");
        students.stream()
                .sorted(Comparator.comparingInt(s -> s.getMarksInMaths() + s.getMarksInScience()))
                .forEach(s -> System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName()));
    }

    // 5. Rank by percentage in descending order
    public void displayStudentsWithRank() {
        System.out.println("\nAll Students with Total, Percentage and Rank:");

        List<StudentQNO12> sorted = new ArrayList<>(students);
        sorted.sort((s1, s2) -> Double.compare(s2.getPercentage(), s1.getPercentage()));

        int rank = 1;
        for (StudentQNO12 s : sorted) {
            System.out.printf("Roll No: %d, Name: %s, Total: %d, Percentage: %.2f, Rank: %d\n",
                    s.getRollNo(), s.getStudName(), s.getTotalMarks(), s.getPercentage(), rank++);
        }
    }
}

public class Studenttwelve {
    public static void main(String[] args) {
        Standard std = new Standard();

        std.displayStudentsByRollNo();
        std.displayTopperByPercentage();
        std.displayTopperByMaths();
        std.displayByMathsAndScienceTotal();
        std.displayStudentsWithRank();
    }
}
/*Students by Roll No:
Roll No: 1, Name: gayathri
Roll No: 2, Name: prudhvy
Roll No: 3, Name: vathsalya
Roll No: 4, Name: Pnandini
Roll No: 5, Name: mukesh
Roll No: 6, Name: skona
Roll No: 7, Name: kannayya
Roll No: 8, Name: pandu

Topper by Percentage:
Roll No: 1, Name: gayathri

Topper in Mathematics:
Roll No: 4, Name: Pnandini

Students by Maths + Science Total:
Roll No: 2, Name: prudhvy
Roll No: 5, Name: mukesh
Roll No: 8, Name: pandu
Roll No: 3, Name: vathsalya
Roll No: 4, Name: Pnandini
Roll No: 7, Name: kannayya
Roll No: 6, Name: skona
Roll No: 1, Name: gayathri

All Students with Total, Percentage and Rank:
Roll No: 1, Name: gayathri, Total: 283, Percentage: 94.33, Rank: 1
Roll No: 6, Name: skona, Total: 264, Percentage: 88.00, Rank: 2
Roll No: 2, Name: prudhvy, Total: 260, Percentage: 86.67, Rank: 3
Roll No: 7, Name: kannayya, Total: 256, Percentage: 85.33, Rank: 4
Roll No: 8, Name: pandu, Total: 250, Percentage: 83.33, Rank: 5
Roll No: 3, Name: vathsalya, Total: 247, Percentage: 82.33, Rank: 6
Roll No: 4, Name: Pnandini, Total: 247, Percentage: 82.33, Rank: 7
Roll No: 5, Name: mukesh, Total: 242, Percentage: 80.67, Rank: 8
*/