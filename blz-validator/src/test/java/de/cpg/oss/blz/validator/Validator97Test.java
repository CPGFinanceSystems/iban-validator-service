package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator97Test {

	private Validator97 validator97 = new Validator97();

	@Test
	public void test1() {

		assertTrue(validator97.isValid("24010019"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validator97.isValid("24010014"));
	}
	
}
