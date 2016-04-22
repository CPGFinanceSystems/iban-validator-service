package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator96Test {

	private Validator96 validator96 = new Validator96();

	@Test
	public void test1() {

		assertTrue(validator96.isValid("0000254100"));
		assertTrue(validator96.isValid("9421000009"));
		assertTrue(validator96.isValid("0000000208"));
		assertTrue(validator96.isValid("0101115152"));
		assertTrue(validator96.isValid("0301204301"));
		assertTrue(validator96.isValid("0001300000"));
		assertTrue(validator96.isValid("0001300001"));
		assertTrue(validator96.isValid("0099399999"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validator96.isValid("0000254101"));
		assertFalse(validator96.isValid("9421030002"));
		assertFalse(validator96.isValid("0000000203"));
		assertFalse(validator96.isValid("0101115154"));
		assertFalse(validator96.isValid("0301204305"));
		assertFalse(validator96.isValid("0001200000"));
		assertFalse(validator96.isValid("0001200001"));
		assertFalse(validator96.isValid("0100000000"));
	}
	
}
