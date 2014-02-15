package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorA3Test {

	private ValidatorA3 validatorA3 = new ValidatorA3();

	@Test
	public void test1() {

		assertTrue(validatorA3.isValid("1234567897"));
		assertTrue(validatorA3.isValid("0123456782"));
		assertTrue(validatorA3.isValid("9876543210"));
		assertTrue(validatorA3.isValid("1234567890"));
		assertTrue(validatorA3.isValid("0123456789"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorA3.isValid("6543217890"));
		assertFalse(validatorA3.isValid("0543216789"));
	}
	
}
