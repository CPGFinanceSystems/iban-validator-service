package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator50Test {

	private Validator50 validator50 = new Validator50();

	@Test
	public void test1() {

		assertTrue(validator50.isValid("4000005001"));
		assertTrue(validator50.isValid("4444442001"));
	}

	@Test
	public void test2() {

		assertFalse(validator50.isValid("4000006001"));
		assertFalse(validator50.isValid("4444448001"));
	}
}
