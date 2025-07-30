package practice1;

import java.util.*;

public class RemoveDuplicatesAndSumevenTwentysix {
    public static void main(String[] args) {
        int[] input = {2, 3, 54, 1, 6, 7, 7};

        
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : input) {
            uniqueSet.add(num);
        }

        
        int evenSum = 0;
        for (int num : uniqueSet) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }

        
        System.out.println("Unique elements: " + uniqueSet);
        System.out.println("Sum of even numbers: " + evenSum);
    }
}
/*Unique elements: [1, 2, 3, 54, 6, 7]
Sum of even numbers: 62
*/
