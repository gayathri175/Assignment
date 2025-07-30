package practice2;
import java.util.Scanner;


@FunctionalInterface
interface MinimumFinder {
 float minimum3(float a, float b, float c);
}

public class MinimumFinderAppThirty {

 private static Scanner scanner;

 public static void main(String[] args) {
     scanner = new Scanner(System.in);

     System.out.print("Enter first number: ");
     float num1 = scanner.nextFloat();

     System.out.print("Enter second number: ");
     float num2 = scanner.nextFloat();

     System.out.print("Enter third number: ");
     float num3 = scanner.nextFloat();

     
     MinimumFinder finder = (a, b, c) -> Math.min(Math.min(a, b), c);

     float smallest = finder.minimum3(num1, num2, num3);

     System.out.println("The smallest number is: " + smallest);
 }
}
/*Enter first number: 1
Enter second number: 2
Enter third number: 4
The smallest number is: 1.0
*/