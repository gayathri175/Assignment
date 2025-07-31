package JUNIT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class QN2 {

    
    public static String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }

  
    public static class StringUtilTest {

        @Test
        public void testReverse_RegularString() {
            assertEquals("olleh", reverse("hello"));     
            assertEquals("avaJ", reverse("Java"));
        }

        @Test
        public void testReverse_EmptyString() {
            assertEquals("", reverse(""));
        }

        @Test
        public void testReverse_NullInput() {
            assertThrows(IllegalArgumentException.class, () -> reverse(null));
        }
    }
}


