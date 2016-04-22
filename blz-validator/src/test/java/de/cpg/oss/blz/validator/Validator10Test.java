package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator10Test {

	private Validator10 validator10 = new Validator10();

	@Test
	public void test1() {

		assertTrue(validator10.isValid("12345008"));
		assertTrue(validator10.isValid("87654008"));
	}

	@Test
	public void test2() {

		assertFalse(validator10.isValid("12345006"));
		assertFalse(validator10.isValid("87654004"));
	}
}
