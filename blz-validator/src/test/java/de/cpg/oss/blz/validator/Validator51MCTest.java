package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator51MCTest {

	private Validator51MC validator51MC = new Validator51MC();

	@Test
	public void test1() {

		assertTrue(validator51MC.isValid("0000156071"));
		assertTrue(validator51MC.isValid("0199100002"));
		assertTrue(validator51MC.isValid("0099100010"));
		assertTrue(validator51MC.isValid("2599100002"));
	}

	@Test
	public void test2() {

		assertFalse(validator51MC.isValid("0000156074"));
	}
}
