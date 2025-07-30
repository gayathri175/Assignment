package practice1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OccuranceCounterFifteen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        System.out.println("Enter 10 integers:");

        // Take 10 input elements
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        // Use HashMap to store occurrences
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        // Print the occurrences
        System.out.println("\nOccurrences of each element:");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times.");
        }

        sc.close();
    }
}
/*Enter 10 integers:
1 2 3 2 4 1 5 2 3 1

Occurrences of each element:
1 occurs 3 times.
2 occurs 3 times.
3 occurs 2 times.
4 occurs 1 times.
5 occurs 1 times.
*/