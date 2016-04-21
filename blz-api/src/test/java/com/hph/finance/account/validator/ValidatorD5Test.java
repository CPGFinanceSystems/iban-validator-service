package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorD5Test {

	private ValidatorD5 validatorD5 = new ValidatorD5();

	@Test
	public void test1() {


		assertTrue(validatorD5.isValid("5999718138"));
		assertTrue(validatorD5.isValid("1799222116"));
		assertTrue(validatorD5.isValid("0099632004"));
		assertTrue(validatorD5.isValid("0004711173"));
		assertTrue(validatorD5.isValid("0007093330"));
		assertTrue(validatorD5.isValid("0000127787"));
		assertTrue(validatorD5.isValid("0004711172"));
		assertTrue(validatorD5.isValid("0007093335"));
		assertTrue(validatorD5.isValid("0000100062"));
		assertTrue(validatorD5.isValid("0000100088"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorD5.isValid("0000100084"));
		assertFalse(validatorD5.isValid("0000100085"));
	}
	
}
