package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator32Test {

	private Validator32 validator32 = new Validator32();

	@Test
	public void test1() {

		assertTrue(validator32.isValid("9141405"));
		assertTrue(validator32.isValid("1709107983"));
		assertTrue(validator32.isValid("0122116979"));
		assertTrue(validator32.isValid("0121114867"));
		assertTrue(validator32.isValid("9030101192"));
		assertTrue(validator32.isValid("9245500460"));
	}

	@Test
	public void test2() {

		assertFalse(validator32.isValid("9141406"));
		assertFalse(validator32.isValid("1709107984"));
		assertFalse(validator32.isValid("0122116976"));
		assertFalse(validator32.isValid("0121114868"));
		assertFalse(validator32.isValid("9030101193"));
		assertFalse(validator32.isValid("9245500464"));
	}
}
