package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorA7Test {

	private ValidatorA7 validatorA7 = new ValidatorA7();

	@Test
	public void test1() {

		assertTrue(validatorA7.isValid("19010008"));
		assertTrue(validatorA7.isValid("19010438"));
		assertTrue(validatorA7.isValid("19010660"));
		assertTrue(validatorA7.isValid("19010876"));
		assertTrue(validatorA7.isValid("209010892"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorA7.isValid("209010893"));
	}
	
}
