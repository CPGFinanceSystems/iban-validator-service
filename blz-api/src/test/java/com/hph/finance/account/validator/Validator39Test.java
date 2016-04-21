package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator39Test {

	private Validator39 validator39 = new Validator39();

	@Test
	public void test1() {

		assertTrue(validator39.isValid("200205"));
		assertTrue(validator39.isValid("10019400"));
	}

	@Test
	public void test2() {

		assertFalse(validator39.isValid("200202"));
		assertFalse(validator39.isValid("10019401"));
	}
}
