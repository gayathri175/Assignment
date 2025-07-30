package practice2;
public class MultipleCatchThirtytwo {
    public static void main(String[] args) {
        try {
            // Uncomment one scenario at a time to test each exception
            // 1. NegativeArraySizeException
            // int[] arr = new int[-5];

            // 2. ArrayIndexOutOfBoundsException
            // int[] arr = new int[3];
            // System.out.println(arr[5]);

            // 3. StringIndexOutOfBoundsException
            // String str = "Hello";
            // System.out.println(str.charAt(10));

            // 4. IndexOutOfBoundsException (for List)
            // java.util.List<Integer> list = new java.util.ArrayList<>();
            // list.add(10);
            // System.out.println(list.get(5));

            // 5. NullPointerException
            // String s = null;
            // System.out.println(s.length());

            

        } catch (NegativeArraySizeException e) {
            System.out.println("Caught NegativeArraySizeException");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Caught a general exception");
            e.printStackTrace();
        }

        System.out.println("\nProgram continues after exception handling...");
    }
}
