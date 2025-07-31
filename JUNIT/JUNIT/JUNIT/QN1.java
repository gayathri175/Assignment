package JUNIT;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class QN1 {

    
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

   
    @Test
    public void testFactorial_ValidInputs() {
        assertEquals(1, factorial(0));
        assertEquals(1, factorial(1));
        assertEquals(2, factorial(2));
        assertEquals(6, factorial(3));
        assertEquals(24, factorial(4));
    }

   
    @Test
    public void testFactorial_NegativeInput_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> factorial(-5));
    }
}


