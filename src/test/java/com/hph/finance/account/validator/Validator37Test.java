package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator37Test {

	private Validator37 validator37 = new Validator37();

	@Test
	public void test1() {

		assertTrue(validator37.isValid("624315"));
		assertTrue(validator37.isValid("632500"));
	}

	@Test
	public void test2() {

		assertFalse(validator37.isValid("624313"));
		assertFalse(validator37.isValid("632504"));
	}
}
