package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator81Test {

	private Validator81 validator81 = new Validator81();

	@Test
	public void test1() {

		assertTrue(validator81.isValid("0646440"));
		assertTrue(validator81.isValid("1359100"));

		assertTrue(validator81.isValid("0199100002"));
		assertTrue(validator81.isValid("0099100010"));
		assertTrue(validator81.isValid("2599100002"));
	}

	@Test
	public void test2() {

		assertFalse(validator81.isValid("0646444"));
		assertFalse(validator81.isValid("1359105"));

		assertFalse(validator81.isValid("0193100003"));
		assertFalse(validator81.isValid("0093100012"));
		assertFalse(validator81.isValid("2593100006"));
	}

}
