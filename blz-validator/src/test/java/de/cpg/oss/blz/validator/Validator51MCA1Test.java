package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator51MCA1Test {

	private Validator51MCA1 validator51MCA1 = new Validator51MCA1();

	@Test
	public void test1() {

		assertTrue(validator51MCA1.isValid("0199100002"));
		assertTrue(validator51MCA1.isValid("0099100010"));
		assertTrue(validator51MCA1.isValid("2599100002"));
	}

	@Test
	public void test2() {

		assertFalse(validator51MCA1.isValid("0199100004"));
		assertFalse(validator51MCA1.isValid("2599100003"));
		assertFalse(validator51MCA1.isValid("0099345678"));
	}
}
