package practice1;
import java.util.Scanner;

public class BikerRaceTwentyfour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] speeds = new double[5];
        double sum = 0;

        // Input speeds
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter speed of biker " + (i + 1) + ": ");
            speeds[i] = scanner.nextDouble();
            sum += speeds[i];
        }

        // Calculate average
        double average = sum / 5;
        System.out.println("\nAverage speed: " + average);

        // Print qualifying racers
        System.out.println("\nQualifying racers (speed > average):");
        boolean anyQualified = false;
        for (double speed : speeds) {
            if (speed > average) {
                System.out.println(speed);
                anyQualified = true;
            }
        }

        if (!anyQualified) {
            System.out.println("No racer qualified.");
        }

        scanner.close();
    }
}
/*Enter speed of biker 1: 89
Enter speed of biker 2: 189
Enter speed of biker 3: 120
Enter speed of biker 4: 40
Enter speed of biker 5: 78

Average speed: 103.2

Qualifying racers (speed > average):
189.0
120.0
*/
