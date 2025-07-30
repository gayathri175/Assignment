package practice1;
import java.util.Scanner;

public class ShopRetailCalculatorTen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0.0;
        char choice='Y';

        do {
            System.out.println("Enter product number (1, 2, 3): ");
            int product = input.nextInt();

            System.out.println("Enter quantity sold: ");
            int quantity = input.nextInt();

            double price = 0;

            switch (product) {
                case 1:
                    price = 22.50;
                    break;
                case 2:
                    price = 44.50;
                    break;
                case 3:
                    price = 9.98;
                    break;
                default:
                    System.out.println("Invalid product number!");
                    continue; 
            }

            double itemTotal = price * quantity;
            total += itemTotal;

            System.out.println("Total for this product: rupees" + itemTotal);

            System.out.print("Do you want to enter another product? (Y/N): ");
            choice = input.next().charAt(0);

        } while (choice == 'Y'|| choice == 'y'); 

        System.out.println("Total retail value of all products sold: rupees" + total);

        input.close();
    }
}

    
/*Enter product number (1, 2, 3): 
3
Enter quantity sold: 
8
Total for this product: rupees79.84
Do you want to enter another product? (Y/N): y
Enter product number (1, 2, 3): 
2
Enter quantity sold: 
9
Total for this product: rupees400.5
Do you want to enter another product? (Y/N): n
Total retail value of all products sold: rupees480.34000000000003
*/

