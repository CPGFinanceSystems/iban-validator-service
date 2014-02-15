package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorC3Test {

	private ValidatorC3 validatorC3 = new ValidatorC3();

	@Test
	public void test1() {


		assertTrue(validatorC3.isValid("9294182"));
		assertTrue(validatorC3.isValid("4431276"));
		assertTrue(validatorC3.isValid("19919"));

		assertTrue(validatorC3.isValid("9000420530"));
		assertTrue(validatorC3.isValid("9000010006"));
		assertTrue(validatorC3.isValid("9000577650"));
	}

	
	@Test
	public void test2() {

		assertFalse(validatorC3.isValid("17002"));
		assertFalse(validatorC3.isValid("123451"));
		assertFalse(validatorC3.isValid("122448"));
		
		assertFalse(validatorC3.isValid("9000734028"));
		assertFalse(validatorC3.isValid("9000733227"));
		assertFalse(validatorC3.isValid("9000731120"));
	}
	
}
