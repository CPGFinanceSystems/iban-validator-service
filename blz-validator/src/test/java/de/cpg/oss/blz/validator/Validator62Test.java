package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator62Test {

	private Validator62 validator62 = new Validator62();

	@Test
	public void test1() {

		assertTrue(validator62.isValid("5029076701"));
	}

	@Test
	public void test2() {

		assertFalse(validator62.isValid("5029076301"));
	}

}
