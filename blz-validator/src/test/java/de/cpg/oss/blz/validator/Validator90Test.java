package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator90Test {

	private Validator90 validator90 = new Validator90();

	@Test
	public void test1() {

		assertTrue(validator90.isValid("0001975641"));
		assertTrue(validator90.isValid("0001988654"));
		assertTrue(validator90.isValid("0000654321"));
		assertTrue(validator90.isValid("0000863530"));
		assertTrue(validator90.isValid("0000784451"));
		assertTrue(validator90.isValid("0000997664"));
		assertTrue(validator90.isValid("0000863536"));
		assertTrue(validator90.isValid("0000654321"));
		assertTrue(validator90.isValid("0000824491"));
		assertTrue(validator90.isValid("0000820484"));
		assertTrue(validator90.isValid("0000654328"));
		assertTrue(validator90.isValid("0000654328"));
		assertTrue(validator90.isValid("0000677747"));
		assertTrue(validator90.isValid("0000840507"));
		assertTrue(validator90.isValid("0000677742"));
		assertTrue(validator90.isValid("0000726391"));
		assertTrue(validator90.isValid("0000996663"));
		assertTrue(validator90.isValid("0000666034"));
		assertTrue(validator90.isValid("0099100002"));
	}

	
	@Test
	public void test2() {	
		
		assertFalse(validator90.isValid("0001975642"));
		assertFalse(validator90.isValid("0001988653"));
		assertFalse(validator90.isValid("0000654324"));
		assertFalse(validator90.isValid("0000863535"));
		assertFalse(validator90.isValid("0000784452"));
		assertFalse(validator90.isValid("0000997667"));
		assertFalse(validator90.isValid("0000863538"));
		assertFalse(validator90.isValid("0000654324"));
		assertFalse(validator90.isValid("0000824490"));
		assertFalse(validator90.isValid("0000820487"));
		assertFalse(validator90.isValid("0000654326"));
		assertFalse(validator90.isValid("0000654325"));
		assertFalse(validator90.isValid("0000677748"));
		assertFalse(validator90.isValid("0000840503"));
		assertFalse(validator90.isValid("0000677741"));
		assertFalse(validator90.isValid("0000726396"));
		assertFalse(validator90.isValid("0000996666"));
		assertFalse(validator90.isValid("0000666037"));
		assertFalse(validator90.isValid("0099100008"));	
	}
	
}
