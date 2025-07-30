package practice2;


public class Fortytwo {

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (Exception e) {
            System.out.println("Exception caught in main:");
            e.printStackTrace();
        }
    }

    public static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.out.println("Exception caught in someMethod, rethrowing...");
            throw e; // Rethrow the exception
        }
    }

    public static void someMethod2() throws Exception {
        throw new Exception("Exception thrown from someMethod2");
    }
}
