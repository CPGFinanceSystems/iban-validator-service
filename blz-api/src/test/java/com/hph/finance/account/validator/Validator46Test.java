package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator46Test {

	private Validator46 validator46 = new Validator46();

	@Test
	public void test1() {

		assertTrue(validator46.isValid("0235468612"));
		assertTrue(validator46.isValid("0837890901"));
		assertTrue(validator46.isValid("1041447600"));
	}

	@Test
	public void test2() {

		assertFalse(validator46.isValid("0235468212"));
		assertFalse(validator46.isValid("0837890301"));
		assertFalse(validator46.isValid("1041447400"));
	}
}
