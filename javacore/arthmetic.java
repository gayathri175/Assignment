package practice1;

public class arthmetic {
    public static void main(String[] args) {
        int num1 = 78;
        int num2 = 89;

        int result = num1 + num2;
        System.out.println("Addition: " + result);

        // Calling methods from MoreOperations class
        MoreOperations.subtract(num1, num2);
        MoreOperations.multiply(num1, num2);
    }
}

// Second class
class MoreOperations {
    public static void subtract(int a, int b) {
        System.out.println("Subtraction: " + (a - b));
    }

    public static void multiply(int a, int b) {
        System.out.println("Multiplication: " + (a * b));
    }
}
