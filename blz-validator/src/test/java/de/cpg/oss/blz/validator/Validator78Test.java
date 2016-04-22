package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator78Test {

	private Validator78 validator78 = new Validator78();

	@Test
	public void test1() {

		assertTrue(validator78.isValid("7581499"));
		assertTrue(validator78.isValid("9999999981"));
	}

	@Test
	public void test2() {

		assertFalse(validator78.isValid("7581492"));
		assertFalse(validator78.isValid("9999999985"));
	}

}
