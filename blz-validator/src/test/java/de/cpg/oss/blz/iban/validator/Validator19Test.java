package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator19Test {

	private Validator19 validator19 = new Validator19();

	@Test
	public void test1() {

		assertTrue(validator19.isValid("0240334000"));
		assertTrue(validator19.isValid("0200520016"));
	}

	@Test
	public void test2() {

		assertFalse(validator19.isValid("0240334002"));
		assertFalse(validator19.isValid("0200520013"));
	}
}
