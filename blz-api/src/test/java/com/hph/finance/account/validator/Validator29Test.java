package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator29Test {

	private Validator29 validator29 = new Validator29();

	@Test
	public void test1() {

		assertTrue(validator29.isValid("3145863029"));
		assertTrue(validator29.isValid("1000061378"));
		assertTrue(validator29.isValid("1000061412"));
		assertTrue(validator29.isValid("4450164064"));
		assertTrue(validator29.isValid("4863476104"));
		assertTrue(validator29.isValid("5000000028"));
		assertTrue(validator29.isValid("5000000391"));
		assertTrue(validator29.isValid("6450008149"));
		assertTrue(validator29.isValid("6800001016"));
		assertTrue(validator29.isValid("9000100012"));
		assertTrue(validator29.isValid("9000210017"));
	}

	@Test
	public void test2() {

		assertFalse(validator29.isValid("3145863024"));
	}
}
