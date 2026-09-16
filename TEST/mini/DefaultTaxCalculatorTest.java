package mini;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultTaxCalculatorTest {

    @Test
    public void testTaxForIL() {
        DefaultTaxCalculator calc = new DefaultTaxCalculator();
        assertEquals(6.0, calc.calculateTax(100.0, "IL"), 0.001);
    }

    @Test
    public void testTaxForCA() {
        DefaultTaxCalculator calc = new DefaultTaxCalculator();
        assertEquals(6.0, calc.calculateTax(100.0, "CA"), 0.001);
    }

    @Test
    public void testTaxForNY() {
        DefaultTaxCalculator calc = new DefaultTaxCalculator();
        assertEquals(6.0, calc.calculateTax(100.0, "NY"), 0.001);
    }

    @Test
    public void testNoTaxForTX() {
        DefaultTaxCalculator calc = new DefaultTaxCalculator();
        assertEquals(0.0, calc.calculateTax(100.0, "TX"), 0.001);
    }
}