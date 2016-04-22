package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator26Test {

	private Validator26 validator26 = new Validator26();

	@Test
	public void test1() {

		assertTrue(validator26.isValid("0520309001"));
		assertTrue(validator26.isValid("1111118111"));
		assertTrue(validator26.isValid("0005501024"));
	}

	@Test
	public void test2() {

		assertFalse(validator26.isValid("0520355555"));
		assertFalse(validator26.isValid("1111777777"));
		assertFalse(validator26.isValid("0005777777"));
	}
}
