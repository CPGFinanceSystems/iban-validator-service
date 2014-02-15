package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator80Test {

	private Validator80 validator80 = new Validator80();

	@Test
	public void test1() {

		assertTrue(validator80.isValid("340968"));
		assertTrue(validator80.isValid("340966"));

		assertTrue(validator80.isValid("0199100002"));
		assertTrue(validator80.isValid("0099100010"));
		assertTrue(validator80.isValid("2599100002"));
	}

	@Test
	public void test2() {

		assertFalse(validator80.isValid("340963"));
		assertFalse(validator80.isValid("340962"));

		assertFalse(validator80.isValid("0193100003"));
		assertFalse(validator80.isValid("0093100012"));
		assertFalse(validator80.isValid("2593100006"));
	}

}
