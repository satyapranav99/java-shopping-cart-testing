package mini;

import java.util.*;
public class DefaultTaxCalculator implements TaxCalculator {
	   private static final Set<String> TAX_STATES = Set.of("IL", "CA", "NY");

	    public double calculateTax(double amount, String state) {
	        return TAX_STATES.contains(state.toUpperCase()) ? amount * 0.06 : 0;
	    }
	}

