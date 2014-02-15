package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator06Test {

	private Validator06 validator06 = new Validator06();

	@Test
	public void test1() {

		assertTrue(validator06.isValid("94012341"));
		assertTrue(validator06.isValid("5073321010"));
	}

	@Test
	public void test2() {

		assertFalse(validator06.isValid("94012344"));
		assertFalse(validator06.isValid("5073321015"));
	}
}
