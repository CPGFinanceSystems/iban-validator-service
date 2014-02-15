package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator54Test {

	private Validator54 validator54 = new Validator54();

	@Test
	public void test1() {

		assertTrue(validator54.isValid("4964137395"));
		assertTrue(validator54.isValid("4900010987"));
	}

	@Test
	public void test2() {

		assertFalse(validator54.isValid("4964137393"));
		assertFalse(validator54.isValid("4900010982"));
	}
}
