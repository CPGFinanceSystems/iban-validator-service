package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator57Test {

	private Validator57 validator57 = new Validator57();

	@Test
	public void test1() {

		assertTrue(validator57.isValid("7500021766"));
		assertTrue(validator57.isValid("9400001734"));
		assertTrue(validator57.isValid("7800028282"));
		assertTrue(validator57.isValid("8100244186"));
		assertTrue(validator57.isValid("3251080371"));
		assertTrue(validator57.isValid("3891234567"));
		assertTrue(validator57.isValid("7777778800"));
		assertTrue(validator57.isValid("5001050352"));
		assertTrue(validator57.isValid("5045090090"));
		assertTrue(validator57.isValid("1909700805"));
		assertTrue(validator57.isValid("9322111030"));
	}

	@Test
	public void test2() {

		assertFalse(validator57.isValid("5302707782"));
		assertFalse(validator57.isValid("6412121212"));
		assertFalse(validator57.isValid("1813499124"));
		assertFalse(validator57.isValid("2206735010"));
	}

}
