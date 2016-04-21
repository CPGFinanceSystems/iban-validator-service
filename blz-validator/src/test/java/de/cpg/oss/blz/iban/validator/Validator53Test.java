package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator53Test {

	private Validator53 validator53 = new Validator53();

	@Test
	public void test1() {

		assertTrue(validator53.isValid("382432256", "16052072"));
	}

	@Test
	public void test2() {

		assertFalse(validator53.isValid("383432256", "16052072"));
	}
}
