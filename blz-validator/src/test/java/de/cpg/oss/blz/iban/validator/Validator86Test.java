package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator86Test {

	private Validator86 validator86 = new Validator86();

	@Test
	public void test1() {

		assertTrue(validator86.isValid("340968"));
		assertTrue(validator86.isValid("1001171"));
		assertTrue(validator86.isValid("1009588"));
		assertTrue(validator86.isValid("123897"));
		assertTrue(validator86.isValid("340960"));
	}

	@Test
	public void test2() {

		assertFalse(validator86.isValid("340964"));
		assertFalse(validator86.isValid("1001176"));
		assertFalse(validator86.isValid("1009587"));
		assertFalse(validator86.isValid("123892"));
		assertFalse(validator86.isValid("340964"));
	}

}
