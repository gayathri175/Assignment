
package practice1;

public class CalculatorEleven {

    // Method to add two numbers
    public void add(int a, int b) {
        int result = a + b;
        System.out.println("Addition: " + result);
    }

    // Method to find the difference
    public void diff(int a, int b) {
        int result = a - b;
        System.out.println("Difference: " + result);
    }

    // Method to multiply
    public void mul(int a, int b) {
        int result = a * b;
        System.out.println("Multiplication: " + result);
    }

    // Method to divide
    public void div(int a, int b) {
        if (b != 0) {
            double result = (double) a / b;  
            System.out.println("Division: " + result);
        } else {
            System.out.println("Division by zero is not allowed.");
        }
    }

   
    public static void main(String[] args) {
        CalculatorEleven calc = new CalculatorEleven(); // Creating object of Calculator class

        int num1 = 20;
        int num2 = 5;

        calc.add(num1, num2);
        calc.diff(num1, num2);
        calc.mul(num1, num2);
        calc.div(num1, num2);
    }
}
/*Addition: 25
Difference: 15
Multiplication: 100
Division: 4.0*/


