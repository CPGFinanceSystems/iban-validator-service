package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator27Test {

	private Validator27 validator27 = new Validator27();

	@Test
	public void test1() {

		assertTrue(validator27.isValid("2847169488"));
	}

	@Test
	public void test2() {

		assertFalse(validator27.isValid("2847169486"));
	}
}
