package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator93Test {

	private Validator93 validator93 = new Validator93();

	@Test
	public void test1() {

		assertTrue(validator93.isValid("6714790000"));
		assertTrue(validator93.isValid("0000671479"));
		assertTrue(validator93.isValid("1277830000"));
		assertTrue(validator93.isValid("0000127783"));
		assertTrue(validator93.isValid("1277910000"));
		assertTrue(validator93.isValid("0000127791"));
		assertTrue(validator93.isValid("3067540000"));
		assertTrue(validator93.isValid("0000306754"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validator93.isValid("8835523421"));
		assertFalse(validator93.isValid("9776644429"));
		assertFalse(validator93.isValid("1231233428"));
		assertFalse(validator93.isValid("1245553427"));
		assertFalse(validator93.isValid("3235833426"));
		assertFalse(validator93.isValid("0008833425"));
		assertFalse(validator93.isValid("1233333424"));
		assertFalse(validator93.isValid("1211113423"));
	}
	
}
