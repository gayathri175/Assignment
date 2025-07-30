package practice1;
public class FrequencyCounter {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 4, 2, 5, 4, 2, 6, 4}; // 10 elements
        boolean[] visited = new boolean[arr.length];

        System.out.println("Element Frequencies:");
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true)
                continue;

            int count = 1; // Start count for current element
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    visited[j] = true; // Mark as counted
                }
            }

            // Print frequency of current element
            System.out.println("Element " + arr[i] + " occurs " + count + " times.");
        }
    }
}
/*Element Frequencies:
Element 4 occurs 4 times.
Element 5 occurs 2 times.
Element 6 occurs 2 times.
Element 2 occurs 2 times.
*/

