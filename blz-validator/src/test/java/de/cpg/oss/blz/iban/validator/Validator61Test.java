package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator61Test {

	private Validator61 validator61 = new Validator61();

	@Test
	public void test1() {

		assertTrue(validator61.isValid("2063099200"));
		assertTrue(validator61.isValid("0260760481"));
	}

	@Test
	public void test2() {

		assertFalse(validator61.isValid("2063099500"));
		assertFalse(validator61.isValid("0260760681"));
	}

}
