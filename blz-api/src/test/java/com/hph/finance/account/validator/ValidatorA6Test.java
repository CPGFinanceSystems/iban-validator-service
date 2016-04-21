package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorA6Test {

	private ValidatorA6 validatorA6 = new ValidatorA6();

	@Test
	public void test1() {

		assertTrue(validatorA6.isValid("800048548"));
		assertTrue(validatorA6.isValid("0855000014"));
		assertTrue(validatorA6.isValid("17"));
		assertTrue(validatorA6.isValid("600003555"));
		assertTrue(validatorA6.isValid("900291823"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorA6.isValid("305888"));
		assertFalse(validatorA6.isValid("200071280"));
	}
	
}
