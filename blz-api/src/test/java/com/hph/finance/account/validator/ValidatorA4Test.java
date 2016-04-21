package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorA4Test {

	private ValidatorA4 validatorA4 = new ValidatorA4();

	@Test
	public void test1() {

		assertTrue(validatorA4.isValid("0004711173"));
		assertTrue(validatorA4.isValid("0007093330"));
		assertTrue(validatorA4.isValid("0004711172"));
		assertTrue(validatorA4.isValid("0007093335"));
		assertTrue(validatorA4.isValid("1199503010"));
		assertTrue(validatorA4.isValid("8499421235"));
		assertTrue(validatorA4.isValid("0000862342"));
		assertTrue(validatorA4.isValid("8997710000"));
		assertTrue(validatorA4.isValid("0664040000"));
		assertTrue(validatorA4.isValid("0000905844"));
		assertTrue(validatorA4.isValid("5030101099"));
		assertTrue(validatorA4.isValid("0001123458"));
		assertTrue(validatorA4.isValid("1299503117"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorA4.isValid("0000399443"));
		assertFalse(validatorA4.isValid("0000553313"));
	}
	
}
