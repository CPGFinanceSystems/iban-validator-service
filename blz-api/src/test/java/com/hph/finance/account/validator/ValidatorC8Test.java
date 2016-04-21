package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorC8Test {

	private ValidatorC8 validatorC8 = new ValidatorC8();

	@Test
	public void test1() {


		assertTrue(validatorC8.isValid("3456789019"));
		assertTrue(validatorC8.isValid("5678901231"));
		assertTrue(validatorC8.isValid("3456789012"));
		assertTrue(validatorC8.isValid("0022007130"));
		assertTrue(validatorC8.isValid("0123456789"));
		assertTrue(validatorC8.isValid("0552071285"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorC8.isValid("1234567890"));
		assertFalse(validatorC8.isValid("9012345678"));
	}
	
}
