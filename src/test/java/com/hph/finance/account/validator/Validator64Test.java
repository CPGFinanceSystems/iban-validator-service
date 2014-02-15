package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator64Test {

	private Validator64 validator64 = new Validator64();

	@Test
	public void test1() {

		assertTrue(validator64.isValid("1206473010"));
		assertTrue(validator64.isValid("5016511020"));
	}

	@Test
	public void test2() {

		assertFalse(validator64.isValid("1206474010"));
		assertFalse(validator64.isValid("5016516020"));
	}

}
