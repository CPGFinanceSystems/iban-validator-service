package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator25Test {

	private Validator25 validator25 = new Validator25();

	@Test
	public void test1() {

		assertTrue(validator25.isValid("521382181"));
	}

	@Test
	public void test2() {

		assertFalse(validator25.isValid("521382153"));
	}
}
