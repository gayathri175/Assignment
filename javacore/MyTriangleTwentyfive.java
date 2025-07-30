package practice1;
import java.util.Scanner;

public class MyTriangleTwentyfive {

   
    public static boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

   
    public static double area(double a, double b, double c) {
        double s = (a + b + c) / 2; 
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    
    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            System.out.print("Enter side a (or -1 to exit): ");
            double a = scanner.nextDouble();

            if (a == -1) {
                System.out.println("Bye~");
                break;
            }

            System.out.print("Enter side b: ");
            double b = scanner.nextDouble();
            System.out.print("Enter side c: ");
            double c = scanner.nextDouble();

            
            if (isValid(a, b, c)) {
               
                System.out.println("Perimeter: " + perimeter(a, b, c));
                System.out.println("Area: " + area(a, b, c));
            } else {
               
                System.out.println("The input is invalid.");
            }

            System.out.println(); 
        }

        scanner.close();
    }
}
/*Enter side a (or -1 to exit): 8
Enter side b: 9
Enter side c: 5
Perimeter: 22.0
Area: 19.8997487421324

Enter side a (or -1 to exit): */