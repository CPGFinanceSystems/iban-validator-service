package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator56Test {

	private Validator56 validator56 = new Validator56();

	@Test
	public void test1() {

		assertTrue(validator56.isValid("0290545005"));
		assertTrue(validator56.isValid("9718304037"));
	}

	@Test
	public void test2() {

		assertFalse(validator56.isValid("0290545002"));
		assertFalse(validator56.isValid("9718304033"));
	}
}
