package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorA8Test {

	private ValidatorA8 validatorA8 = new ValidatorA8();

	@Test
	public void test1() {

		assertTrue(validatorA8.isValid("7436661"));
		assertTrue(validatorA8.isValid("7436670"));
		assertTrue(validatorA8.isValid("1359100"));
		assertTrue(validatorA8.isValid("7436660"));
		assertTrue(validatorA8.isValid("7436678"));
		assertTrue(validatorA8.isValid("0003503398"));
		assertTrue(validatorA8.isValid("0001340967"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorA8.isValid("7436666"));
		assertFalse(validatorA8.isValid("7436677"));
		assertFalse(validatorA8.isValid("0003503391"));
		assertFalse(validatorA8.isValid("0001340966"));
	}
	
}
