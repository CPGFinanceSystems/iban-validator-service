package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator41Test {

	private Validator41 validator41 = new Validator41();

	@Test
	public void test1() {

		assertTrue(validator41.isValid("4013410024"));
		assertTrue(validator41.isValid("4016660195"));
		assertTrue(validator41.isValid("0166805317"));
		assertTrue(validator41.isValid("4019310079"));
		assertTrue(validator41.isValid("4019340829"));
		assertTrue(validator41.isValid("4019151002"));
	}

	@Test
	public void test2() {

		assertFalse(validator41.isValid("4013410021"));
		assertFalse(validator41.isValid("4016660196"));
		assertFalse(validator41.isValid("0166805312"));
		assertFalse(validator41.isValid("4019310073"));
		assertFalse(validator41.isValid("4019340824"));
		assertFalse(validator41.isValid("4019151006"));
	}
}
