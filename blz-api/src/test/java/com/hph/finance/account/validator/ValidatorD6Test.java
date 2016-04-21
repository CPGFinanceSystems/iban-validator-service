package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorD6Test {

	private ValidatorD6 validatorD6 = new ValidatorD6();

	@Test
	public void test1() {


		assertTrue(validatorD6.isValid("3409"));
		assertTrue(validatorD6.isValid("585327"));
		assertTrue(validatorD6.isValid("1650513"));
		assertTrue(validatorD6.isValid("3601671056"));
		assertTrue(validatorD6.isValid("4402001046"));
		assertTrue(validatorD6.isValid("6100268241"));
		assertTrue(validatorD6.isValid("7001000681"));
		assertTrue(validatorD6.isValid("9000111105"));
		assertTrue(validatorD6.isValid("9001291005"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorD6.isValid("7004017653"));
		assertFalse(validatorD6.isValid("9002720007"));
		assertFalse(validatorD6.isValid("9017483524"));
	}
	
}
