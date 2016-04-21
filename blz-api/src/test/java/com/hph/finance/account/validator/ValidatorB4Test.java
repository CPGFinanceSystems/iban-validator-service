package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorB4Test {

	private ValidatorB4 validatorB4 = new ValidatorB4();

	@Test
	public void test1() {

		assertTrue(validatorB4.isValid("9941510001"));
		assertTrue(validatorB4.isValid("9961230019"));
		assertTrue(validatorB4.isValid("9380027210"));
		assertTrue(validatorB4.isValid("9932290910"));
		assertTrue(validatorB4.isValid("0000251437"));
		assertTrue(validatorB4.isValid("0007948344"));
		assertTrue(validatorB4.isValid("0000051640"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorB4.isValid("0000251438"));
		assertFalse(validatorB4.isValid("0007948345"));
		assertFalse(validatorB4.isValid("0000159590"));

	}
	
}
