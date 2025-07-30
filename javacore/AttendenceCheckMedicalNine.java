package practice1;
import java.util.Scanner;

public class AttendenceCheckMedicalNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Classes held: ");
        int held = sc.nextInt();

        System.out.print("Classes attended: ");
        int attended = sc.nextInt();

        double percent = (attended * 100.0) / held;
        System.out.println("Attendance: " + percent + "%");

        System.out.print("Do you have medical cause? (Y/N): ");
        char medical = sc.next().charAt(0);

        if (percent >= 70 || medical == 'Y') {
            System.out.println("Allowed to sit in exam ");
        } else {
            System.out.println("Not allowed to sit in exam ");
        }

        sc.close();
    }
}
/* Classes held: 8
Classes attended: 9
Attendance: 112.5%
Do you have medical cause? (Y/N): n
Allowed to sit in exam */

