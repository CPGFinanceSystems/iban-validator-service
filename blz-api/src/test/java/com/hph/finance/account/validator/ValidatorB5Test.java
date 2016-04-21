package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorB5Test {

	private ValidatorB5 validatorB5 = new ValidatorB5();

	@Test
	public void test1() {

		assertTrue(validatorB5.isValid("0159006955"));
		assertTrue(validatorB5.isValid("2000123451"));
		assertTrue(validatorB5.isValid("1151043216"));
		assertTrue(validatorB5.isValid("9000939033"));
		assertTrue(validatorB5.isValid("0123456782"));
		assertTrue(validatorB5.isValid("0130098767"));
		assertTrue(validatorB5.isValid("1045000252"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorB5.isValid("0159004165"));
		assertFalse(validatorB5.isValid("0023456787"));
		assertFalse(validatorB5.isValid("0056789018"));
		assertFalse(validatorB5.isValid("3045000333"));
	}
	
}
