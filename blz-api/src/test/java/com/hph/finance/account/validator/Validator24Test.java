package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator24Test {

	private Validator24 validator24 = new Validator24();

	@Test
	public void test1() {

		assertTrue(validator24.isValid("138301"));
		assertTrue(validator24.isValid("1306118605"));
		assertTrue(validator24.isValid("3307118608"));
		assertTrue(validator24.isValid("9307118603"));
	}

	@Test
	public void test2() {

		assertFalse(validator24.isValid("138305"));
		assertFalse(validator24.isValid("130611863"));
		assertFalse(validator24.isValid("3307118606"));
		assertFalse(validator24.isValid("9307118607"));
	}
}
