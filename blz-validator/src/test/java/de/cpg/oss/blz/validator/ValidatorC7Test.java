package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorC7Test {

	private ValidatorC7 validatorC7 = new ValidatorC7();

	@Test
	public void test1() {


		assertTrue(validatorC7.isValid("94012341"));
		assertTrue(validatorC7.isValid("5073321010"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorC7.isValid("1234517892"));
		assertFalse(validatorC7.isValid("987614325"));
	}
	
}
