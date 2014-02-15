package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator65Test {

	private Validator65 validator65 = new Validator65();

	@Test
	public void test1() {

		assertTrue(validator65.isValid("1234567400"));
		assertTrue(validator65.isValid("1234567590"));
	}

	@Test
	public void test2() {

		assertFalse(validator65.isValid("1234567700"));
		assertFalse(validator65.isValid("1234567290"));
	}

}
