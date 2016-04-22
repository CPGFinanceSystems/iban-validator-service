package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorA2Test {

	private ValidatorA2 validatorA2 = new ValidatorA2();

	@Test
	public void test1() {

		assertTrue(validatorA2.isValid("3456789019"));
		assertTrue(validatorA2.isValid("5678901231"));
		assertTrue(validatorA2.isValid("6789012348"));
		assertTrue(validatorA2.isValid("3456789012"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorA2.isValid("1234567890"));
		assertFalse(validatorA2.isValid("0123456789"));
	}
	
}
