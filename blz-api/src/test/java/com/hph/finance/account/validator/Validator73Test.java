package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator73Test {

	private Validator73 validator73 = new Validator73();

	@Test
	public void test1() {

		assertTrue(validator73.isValid("0003503398"));
		assertTrue(validator73.isValid("0001340967"));

		assertTrue(validator73.isValid("0003503391"));
		assertTrue(validator73.isValid("0001340968"));

		assertTrue(validator73.isValid("0003503392"));
		assertTrue(validator73.isValid("0001340966"));
		assertTrue(validator73.isValid("123456"));
	}

	@Test
	public void test2() {

		assertFalse(validator73.isValid("0003503393"));
		assertFalse(validator73.isValid("0001340962"));

		assertFalse(validator73.isValid("0003503394"));
		assertFalse(validator73.isValid("0001340965"));

		assertFalse(validator73.isValid("0003503393"));
		assertFalse(validator73.isValid("0001340964"));
		assertFalse(validator73.isValid("123458"));
	}

}
