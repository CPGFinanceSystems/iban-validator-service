package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorA0Test {

	private ValidatorA0 validatorA0 = new ValidatorA0();

	@Test
	public void test1() {

		assertTrue(validatorA0.isValid("521003287"));
		assertTrue(validatorA0.isValid("54500"));
		assertTrue(validatorA0.isValid("3287"));
		assertTrue(validatorA0.isValid("18761"));
		assertTrue(validatorA0.isValid("28290"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorA0.isValid("521003282"));
		assertFalse(validatorA0.isValid("54503"));
		assertFalse(validatorA0.isValid("3284"));
		assertFalse(validatorA0.isValid("18765"));
		assertFalse(validatorA0.isValid("28296"));
	}
	
}
