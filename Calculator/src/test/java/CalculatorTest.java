import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        calculator.add(5);
        calculator.add(10);
        assertEquals(15, calculator.getSum());
    }

    @Test
    // Test that the add method throws an exception when a negative number is given.
    public void testAddNegative() {
        Calculator calculator = new Calculator();
        try {
            calculator.add(-5);
        } catch (IllegalArgumentException e) {
            assertEquals("The given number must be positive.", e.getMessage());
        }
    }

    @Test
    public void testResetValue() {
        Calculator calculator = new Calculator();
        calculator.add(5);
        calculator.add(10);
        calculator.reset();
        assertEquals(0, calculator.getSum());
    }
}
