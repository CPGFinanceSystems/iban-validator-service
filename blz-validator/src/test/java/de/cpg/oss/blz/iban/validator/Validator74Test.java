package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator74Test {

	private Validator74 validator74 = new Validator74();

	@Test
	public void test1() {

		assertTrue(validator74.isValid("1016"));
		assertTrue(validator74.isValid("26260"));
		assertTrue(validator74.isValid("242243"));
		assertTrue(validator74.isValid("242248"));
		assertTrue(validator74.isValid("18002113"));
		assertTrue(validator74.isValid("1821200043"));
	}

	@Test
	public void test2() {

		assertFalse(validator74.isValid("1011"));
		assertFalse(validator74.isValid("26265"));
		assertFalse(validator74.isValid("18002118"));
		assertFalse(validator74.isValid("6160000024"));
	}

}
