package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator31Test {

	private Validator31 validator31 = new Validator31();

	@Test
	public void test1() {

		assertTrue(validator31.isValid("1000000524"));
		assertTrue(validator31.isValid("1000000583"));
	}

	@Test
	public void test2() {

		assertFalse(validator31.isValid("1000000526"));
		assertFalse(validator31.isValid("1000000585"));
	}
}
