package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator95Test {

	private Validator95 validator95 = new Validator95();

	@Test
	public void test1() {

		assertTrue(validator95.isValid("0068007003"));
		assertTrue(validator95.isValid("0847321750"));
		assertTrue(validator95.isValid("6450060494"));
		assertTrue(validator95.isValid("6454000003"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validator95.isValid("0068007004"));
		assertFalse(validator95.isValid("0847321755"));
		assertFalse(validator95.isValid("6450060496"));
		assertFalse(validator95.isValid("6454000007"));
	}
	
}
