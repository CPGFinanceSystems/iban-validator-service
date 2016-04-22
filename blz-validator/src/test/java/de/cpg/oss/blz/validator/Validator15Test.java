package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator15Test {

	private Validator15 validator15 = new Validator15();

	@Test
	public void test1() {

		assertTrue(validator15.isValid("0000000019"));
		assertTrue(validator15.isValid("0000292932"));
		assertTrue(validator15.isValid("0000094455"));
	}

	@Test
	public void test2() {

		assertFalse(validator15.isValid("0000000017"));
		assertFalse(validator15.isValid("0000292933"));
		assertFalse(validator15.isValid("0000094459"));
	}
}
