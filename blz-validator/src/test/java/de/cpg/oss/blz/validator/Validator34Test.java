package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator34Test {

	private Validator34 validator34 = new Validator34();

	@Test
	public void test1() {

		assertTrue(validator34.isValid("9913000700"));
		assertTrue(validator34.isValid("9914001000"));
	}

	@Test
	public void test2() {

		assertFalse(validator34.isValid("9913000400"));
		assertFalse(validator34.isValid("9914001200"));
	}
}
