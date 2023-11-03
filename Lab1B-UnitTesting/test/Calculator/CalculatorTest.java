package Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator c1 = new Calculator(2,8);
    Calculator c2 = new Calculator(-2, 3);
    Calculator c3 = new Calculator(2, -3);
    Calculator c4 = new Calculator(-2, -3);
    Calculator c5 = new Calculator(0, 0);
    Calculator c6 = new Calculator(0, 3);
    Calculator c7 = new Calculator(2, 0);
    Calculator c8 = new Calculator(0, -3);
    Calculator c9 = new Calculator(-2, 0);
    @Test
    void testAdd() {
        assertEquals(10, c1.add());
        assertEquals(-2, c9.add());
        assertEquals(3, c6.add());
        assertEquals(0, c5.add());
    }

    @Test
    void testSubtract() {
        assertEquals(-6, c1.subtract());
        assertEquals(0, c5.subtract());
        assertEquals(2, c7.subtract());
        assertEquals(-3, c6.subtract());
    }

    @Test
    void testMultiply() {
        assertEquals(16, c1.multiply());
        assertEquals(-6, c2.multiply());
        assertEquals(6, c4.multiply());
        assertEquals(0, c5.multiply());
    }

    @Test
    void testDivide() {
        Calculator c2 = new Calculator(8,0);
        assertThrows(ArithmeticException.class, () -> c2.divide());
        assertDoesNotThrow(() -> c4.divide(), "Error beep boop bop");

    }
}