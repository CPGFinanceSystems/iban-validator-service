package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator83Test {

	private Validator83 validator83 = new Validator83();

	@Test
	public void test1() {

		assertTrue(validator83.isValid("0001156071"));
		assertTrue(validator83.isValid("0001156136"));
		assertTrue(validator83.isValid("0000156078"));
		assertTrue(validator83.isValid("0000156071"));
	}

	@Test
	public void test2() {

		assertFalse(validator83.isValid("0001156072"));
		assertFalse(validator83.isValid("0001156133"));
		assertFalse(validator83.isValid("0000156074"));
		assertFalse(validator83.isValid("0000156075"));
	}

}
