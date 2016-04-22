package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator28Test {

	private Validator28 validator28 = new Validator28();

	@Test
	public void test1() {

		assertTrue(validator28.isValid("19999000"));
		assertTrue(validator28.isValid("9130000201"));
	}

	@Test
	public void test2() {

		assertFalse(validator28.isValid("19999555"));
		assertFalse(validator28.isValid("9130000701"));
	}
}
