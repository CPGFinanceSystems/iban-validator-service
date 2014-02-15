package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator98Test {

	private Validator98 validator98 = new Validator98();

	@Test
	public void test1() {

		assertTrue(validator98.isValid("9619439213"));
		assertTrue(validator98.isValid("9619509976"));
		assertTrue(validator98.isValid("9619319999"));
		assertTrue(validator98.isValid("3009800016"));
		assertTrue(validator98.isValid("5989800173"));
		assertTrue(validator98.isValid("6719430018"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validator98.isValid("9619439214"));
		assertFalse(validator98.isValid("9619509975"));
		assertFalse(validator98.isValid("9619319996"));
		assertFalse(validator98.isValid("3009800017"));
		assertFalse(validator98.isValid("5989800178"));
		assertFalse(validator98.isValid("6719430019"));
	}
	
}
