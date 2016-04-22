package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator42Test {

	private Validator42 validator42 = new Validator42();

	@Test
	public void test1() {

		assertTrue(validator42.isValid("59498"));
		assertTrue(validator42.isValid("59510"));
	}

	@Test
	public void test2() {

		assertFalse(validator42.isValid("59493"));
		assertFalse(validator42.isValid("59512"));
	}
}
