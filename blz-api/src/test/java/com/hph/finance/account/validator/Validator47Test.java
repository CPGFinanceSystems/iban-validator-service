package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator47Test {

	private Validator47 validator47 = new Validator47();

	@Test
	public void test1() {

		assertTrue(validator47.isValid("1018000"));
		assertTrue(validator47.isValid("1003554450"));
	}

	@Test
	public void test2() {

		assertFalse(validator47.isValid("1018022"));
		assertFalse(validator47.isValid("1003554444"));
	}
}
