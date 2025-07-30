package practice2;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class RegistrationValidatorTwentyNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Register Number: ");
            String regNo = sc.nextLine();

            System.out.print("Enter Mobile Number: ");
            String mobileNo = sc.nextLine();

            if (regNo.length() != 9 || mobileNo.length() != 10) {
                throw new IllegalArgumentException();
            }

            if (!mobileNo.matches("\\d{10}")) {
                throw new NumberFormatException();
            }

            if (!regNo.matches("[a-zA-Z0-9]{9}")) {
                throw new NoSuchElementException();
            }

            System.out.println("valid");
        } catch (NumberFormatException e) {
            System.out.println("invalid");
        } catch (NoSuchElementException e) {
            System.out.println("invalid");
        } catch (IllegalArgumentException e) {
            System.out.println("invalid");
        } finally {
            sc.close();
        }
    }
}
/*Enter Register Number: 891
Enter Mobile Number: 8919839134
invalid
*/