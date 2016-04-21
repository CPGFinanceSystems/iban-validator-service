package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorA5Test {

	private ValidatorA5 validatorA5 = new ValidatorA5();

	@Test
	public void test1() {

		assertTrue(validatorA5.isValid("9941510001"));
		assertTrue(validatorA5.isValid("9961230019"));
		assertTrue(validatorA5.isValid("9380027210"));
		assertTrue(validatorA5.isValid("9932290910"));
		assertTrue(validatorA5.isValid("0000251437"));
		assertTrue(validatorA5.isValid("0007948344"));
		assertTrue(validatorA5.isValid("0000159590"));
		assertTrue(validatorA5.isValid("0000051640"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorA5.isValid("0000251438"));
		assertFalse(validatorA5.isValid("0007948345"));
	}
	
}
