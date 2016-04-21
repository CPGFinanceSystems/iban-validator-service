package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator40Test {

	private Validator40 validator40 = new Validator40();

	@Test
	public void test1() {

		assertTrue(validator40.isValid("1258345"));
		assertTrue(validator40.isValid("3231963"));
	}

	@Test
	public void test2() {

		assertFalse(validator40.isValid("1258342"));
		assertFalse(validator40.isValid("3231966"));
	}
}
