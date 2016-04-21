package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorA1Test {

	private ValidatorA1 validatorA1 = new ValidatorA1();

	@Test
	public void test1() {

		assertTrue(validatorA1.isValid("0010030005"));
		assertTrue(validatorA1.isValid("0010030997"));
		assertTrue(validatorA1.isValid("1010030054"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorA1.isValid("0110030005"));
		assertFalse(validatorA1.isValid("0010030998"));
		assertFalse(validatorA1.isValid("0000030005"));
	}
	
}
