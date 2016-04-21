package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorA9Test {

	private ValidatorA9 validatorA9 = new ValidatorA9();

	@Test
	public void test1() {

		assertTrue(validatorA9.isValid("5043608"));
		assertTrue(validatorA9.isValid("86725"));
		assertTrue(validatorA9.isValid("504360"));
		assertTrue(validatorA9.isValid("822035"));
		assertTrue(validatorA9.isValid("32577083"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorA9.isValid("86724"));
		assertFalse(validatorA9.isValid("292497"));
		assertFalse(validatorA9.isValid("30767208"));
	}
	
}
