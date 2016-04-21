package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator76Test {

	private Validator76 validator76 = new Validator76();

	@Test
	public void test1() {

		assertTrue(validator76.isValid("0006543200"));
		assertTrue(validator76.isValid("9012345600"));
		assertTrue(validator76.isValid("7876543100"));
	}

	@Test
	public void test2() {

		assertFalse(validator76.isValid("0006542200"));
		assertFalse(validator76.isValid("9012341600"));
		assertFalse(validator76.isValid("7876545100"));
	}

}
