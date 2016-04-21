package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator66Test {

	private Validator66 validator66 = new Validator66();

	@Test
	public void test1() {

		assertTrue(validator66.isValid("100154508"));
		assertTrue(validator66.isValid("101154508"));
		assertTrue(validator66.isValid("100154516"));
		assertTrue(validator66.isValid("101154516"));
	}

	@Test
	public void test2() {

		assertFalse(validator66.isValid("100154503"));
		assertFalse(validator66.isValid("101154502"));
		assertFalse(validator66.isValid("100154513"));
		assertFalse(validator66.isValid("101154511"));
	}

}
