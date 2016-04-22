package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorB1Test {

	private ValidatorB1 validatorB1 = new ValidatorB1();

	@Test
	public void test1() {

		assertTrue(validatorB1.isValid("1434253150"));
		assertTrue(validatorB1.isValid("2746315471"));
		assertTrue(validatorB1.isValid("7414398260"));
		assertTrue(validatorB1.isValid("8347251693"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorB1.isValid("0123456789"));
		assertFalse(validatorB1.isValid("2345678901"));
		assertFalse(validatorB1.isValid("5678901234"));

	}
	
}
