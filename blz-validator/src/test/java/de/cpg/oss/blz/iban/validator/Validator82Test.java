package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator82Test {

	private Validator82 validator82 = new Validator82();

	@Test
	public void test1() {

		assertTrue(validator82.isValid("123897"));
		assertTrue(validator82.isValid("3199500501"));
	}

	@Test
	public void test2() {

		assertFalse(validator82.isValid("123894"));
		assertFalse(validator82.isValid("3199500506"));
	}

}
