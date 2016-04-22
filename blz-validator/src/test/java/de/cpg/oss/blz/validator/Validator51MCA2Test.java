package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator51MCA2Test {

	private Validator51MCA2 validator51MCA2 = new Validator51MCA2();

	@Test
	public void test1() {

		assertTrue(validator51MCA2.isValid("0199100004"));
		assertTrue(validator51MCA2.isValid("2599100003"));
		assertTrue(validator51MCA2.isValid("3199204090"));
	}

	@Test
	public void test2() {

		assertFalse(validator51MCA2.isValid("0099345678"));
		assertFalse(validator51MCA2.isValid("0099100110"));
		assertFalse(validator51MCA2.isValid("0199100040"));
	}
}
