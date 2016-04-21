package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator68Test {

	private Validator68 validator68 = new Validator68();

	@Test
	public void test1() {

		assertTrue(validator68.isValid("8889654328"));
		assertTrue(validator68.isValid("987654324"));
		assertTrue(validator68.isValid("987654328"));
	}

	@Test
	public void test2() {

		assertFalse(validator68.isValid("500000000"));
		assertFalse(validator68.isValid("599999999"));
		assertFalse(validator68.isValid("599999998"));
	}

}
