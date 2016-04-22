package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator75Test {

	private Validator75 validator75 = new Validator75();

	@Test
	public void test1() {

		assertTrue(validator75.isValid("0000301168"));
		assertTrue(validator75.isValid("0000302554"));
		assertTrue(validator75.isValid("0300020050"));
		assertTrue(validator75.isValid("0300566000"));
	}

	@Test
	public void test2() {

		assertFalse(validator75.isValid("0000302589"));
		assertFalse(validator75.isValid("0000507336"));
		assertFalse(validator75.isValid("0302555000"));
		assertFalse(validator75.isValid("0302589000"));
	}

}
