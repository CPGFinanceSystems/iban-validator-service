package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator35Test {

	private Validator35 validator35 = new Validator35();

	@Test
	public void test1() {

		assertTrue(validator35.isValid("0000108443"));
		assertTrue(validator35.isValid("0000107451"));
		assertTrue(validator35.isValid("0000102921"));
		assertTrue(validator35.isValid("0000102349"));
		assertTrue(validator35.isValid("0000101709"));
		assertTrue(validator35.isValid("0000101599"));
	}

	@Test
	public void test2() {

		assertFalse(validator35.isValid("0000108445"));
		assertFalse(validator35.isValid("0000107456"));
		assertFalse(validator35.isValid("0000102927"));
		assertFalse(validator35.isValid("0000102348"));
		assertFalse(validator35.isValid("0000101701"));
		assertFalse(validator35.isValid("0000101594"));
	}
}
