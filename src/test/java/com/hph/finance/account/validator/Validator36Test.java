package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator36Test {

	private Validator36 validator36 = new Validator36();

	@Test
	public void test1() {

		assertTrue(validator36.isValid("113178"));
		assertTrue(validator36.isValid("146666"));
	}

	@Test
	public void test2() {

		assertFalse(validator36.isValid("113174"));
		assertFalse(validator36.isValid("146663"));
	}
}
