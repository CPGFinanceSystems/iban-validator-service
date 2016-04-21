package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator17Test {

	private Validator17 validator17 = new Validator17();

	@Test
	public void test1() {

		assertTrue(validator17.isValid("0446786040"));
	}

	@Test
	public void test2() {

		assertFalse(validator17.isValid("0446786243"));
	}
}
