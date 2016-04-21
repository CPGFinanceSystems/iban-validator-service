package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator38Test {

	private Validator38 validator38 = new Validator38();

	@Test
	public void test1() {

		assertTrue(validator38.isValid("191919"));
		assertTrue(validator38.isValid("1100660"));
	}

	@Test
	public void test2() {

		assertFalse(validator38.isValid("191912"));
		assertFalse(validator38.isValid("1100663"));
	}
}
