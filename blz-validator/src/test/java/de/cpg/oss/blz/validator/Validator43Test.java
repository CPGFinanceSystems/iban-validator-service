package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator43Test {

	private Validator43 validator43 = new Validator43();

	@Test
	public void test1() {

		assertTrue(validator43.isValid("6135244"));
		assertTrue(validator43.isValid("9516893476"));
	}

	@Test
	public void test2() {

		assertFalse(validator43.isValid("6135243"));
		assertFalse(validator43.isValid("9516893472"));
	}
}
