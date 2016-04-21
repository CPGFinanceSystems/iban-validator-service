package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorD9Test {

	private ValidatorD9 validatorD9 = new ValidatorD9();

	@Test
	public void test1() {


		assertTrue(validatorD9.isValid("1234567897"));
		assertTrue(validatorD9.isValid("0123456782"));
		assertTrue(validatorD9.isValid("9876543210"));
		assertTrue(validatorD9.isValid("1234567890"));
		assertTrue(validatorD9.isValid("0123456789"));
		assertTrue(validatorD9.isValid("1100132044"));
		assertTrue(validatorD9.isValid("1100669030"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorD9.isValid("1100789043"));
		assertFalse(validatorD9.isValid("1100914032"));
	}
	
}
