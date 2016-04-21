package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorB2Test {

	private ValidatorB2 validatorB2 = new ValidatorB2();

	@Test
	public void test1() {

		assertTrue(validatorB2.isValid("0020012357"));
		assertTrue(validatorB2.isValid("0080012345"));
		assertTrue(validatorB2.isValid("0926801910"));
		assertTrue(validatorB2.isValid("1002345674"));
		assertTrue(validatorB2.isValid("8000990054"));
		assertTrue(validatorB2.isValid("9000481805"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorB2.isValid("8000990057"));
		assertFalse(validatorB2.isValid("8011000126"));
		assertFalse(validatorB2.isValid("9000481800"));
		assertFalse(validatorB2.isValid("9980480111"));

	}
	
}
