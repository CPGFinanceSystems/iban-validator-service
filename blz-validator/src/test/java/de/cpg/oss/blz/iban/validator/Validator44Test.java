package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator44Test {

	private Validator44 validator44 = new Validator44();

	@Test
	public void test1() {

		assertTrue(validator44.isValid("889006"));
		assertTrue(validator44.isValid("2618040504"));
	}

	@Test
	public void test2() {

		assertFalse(validator44.isValid("889002"));
		assertFalse(validator44.isValid("2618040503"));
	}
}
