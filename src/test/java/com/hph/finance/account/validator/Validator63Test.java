package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator63Test {

	private Validator63 validator63 = new Validator63();

	@Test
	public void test1() {

		assertTrue(validator63.isValid("0123456600"));
		assertTrue(validator63.isValid("0001234566"));
	}

	@Test
	public void test2() {

		assertFalse(validator63.isValid("1234563003"));
		assertFalse(validator63.isValid("2001234566"));
	}

}
