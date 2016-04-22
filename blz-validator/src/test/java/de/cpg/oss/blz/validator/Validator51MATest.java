package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator51MATest {

	private Validator51MA validator51MA = new Validator51MA();

	@Test
	public void test1() {

		assertTrue(validator51MA.isValid("0001156071"));
		assertTrue(validator51MA.isValid("0001156136"));
	}

	@Test
	public void test2() {

		assertFalse(validator51MA.isValid("0001156075"));
		assertFalse(validator51MA.isValid("0001156137"));
	}
}
