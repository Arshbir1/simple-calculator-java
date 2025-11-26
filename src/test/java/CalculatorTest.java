import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        assertEquals(5, c.add(2, 3));
    }

    @Test
    public void testSub() {
        Calculator c = new Calculator();
        assertEquals(3, c.sub(5, 2));
    }

    @Test
    public void testMul() {
        Calculator c = new Calculator();
        assertEquals(12, c.mul(3, 4));
    }

    @Test
    public void testDiv() {
        Calculator c = new Calculator();
        assertEquals(5, c.div(10, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivByZero() {
        Calculator c = new Calculator();
        c.div(10, 0);
    }
}
