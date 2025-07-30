package practice2;

import java.util.Scanner;

interface PerformOperation {
    boolean check(int a);
}

public class NumberCheckerTwentyEight {

    public static PerformOperation isOdd() {
        return a -> a % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return a -> {
            if (a < 2) return false;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return a -> {
            String str = Integer.toString(a);
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        PerformOperation oddCheck = isOdd();
        PerformOperation primeCheck = isPrime();
        PerformOperation palindromeCheck = isPalindrome();

        System.out.println("Is " + num + " odd? " + oddCheck.check(num));
        System.out.println("Is " + num + " prime? " + primeCheck.check(num));
        System.out.println("Is " + num + " palindrome? " + palindromeCheck.check(num));

        sc.close();
    }
}
/*Enter a number: 8
Is 8 odd? false
Is 8 prime? false
Is 8 palindrome? true
*/