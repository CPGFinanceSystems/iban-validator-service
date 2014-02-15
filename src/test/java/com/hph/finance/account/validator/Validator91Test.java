package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator91Test {

	private Validator91 validator91 = new Validator91();

	@Test
	public void test1() {

		assertTrue(validator91.isValid("2974118000"));
		assertTrue(validator91.isValid("5281741000"));
		assertTrue(validator91.isValid("9952810000"));
		assertTrue(validator91.isValid("2974117000"));
		assertTrue(validator91.isValid("5281770000"));
		assertTrue(validator91.isValid("9952812000"));
		assertTrue(validator91.isValid("8840019000"));
		assertTrue(validator91.isValid("8840050000"));
		assertTrue(validator91.isValid("8840087000"));
		assertTrue(validator91.isValid("8840045000"));
		assertTrue(validator91.isValid("8840012000"));
		assertTrue(validator91.isValid("8840055000"));
		assertTrue(validator91.isValid("8840080000"));
		assertTrue(validator91.isValid("8840045000"));
	}

	
	@Test
	public void test2() {	
		
		assertFalse(validator91.isValid("8840017000"));
		assertFalse(validator91.isValid("8840023000"));
		assertFalse(validator91.isValid("8840041000"));
		assertFalse(validator91.isValid("8840014000"));
		assertFalse(validator91.isValid("8840026000"));
		assertFalse(validator91.isValid("8840011000"));
		assertFalse(validator91.isValid("8840025000"));
		assertFalse(validator91.isValid("8840062000"));
		assertFalse(validator91.isValid("8840010000"));
		assertFalse(validator91.isValid("8840057000"));
	}
	
}
