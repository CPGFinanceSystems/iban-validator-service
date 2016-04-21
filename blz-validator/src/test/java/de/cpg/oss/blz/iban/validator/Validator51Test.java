package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator51Test {

	private Validator51 validator51 = new Validator51();

	@Test
	public void test1() {

		assertTrue(validator51.isValid("0001156071"));
		assertTrue(validator51.isValid("0001156136"));
		assertTrue(validator51.isValid("0000156078"));
		assertTrue(validator51.isValid("0000156071"));
		assertTrue(validator51.isValid("0199100002"));
		assertTrue(validator51.isValid("0099100010"));
		assertTrue(validator51.isValid("2599100002"));
		assertTrue(validator51.isValid("0199100004"));
		assertTrue(validator51.isValid("2599100003"));
		assertTrue(validator51.isValid("3199204090"));
	}

	@Test
	public void test2() {

		assertFalse(validator51.isValid("0001156074"));
		assertFalse(validator51.isValid("0001156133"));
		assertFalse(validator51.isValid("0000156072"));
		assertFalse(validator51.isValid("0199100001"));
		assertFalse(validator51.isValid("2599100006"));
		assertFalse(validator51.isValid("0099345670"));
		assertFalse(validator51.isValid("0099345675"));
		assertFalse(validator51.isValid("0099100114"));
		assertFalse(validator51.isValid("0199100043"));
	}
}
