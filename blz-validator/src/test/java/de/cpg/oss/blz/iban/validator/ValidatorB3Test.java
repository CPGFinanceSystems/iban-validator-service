package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorB3Test {

	private ValidatorB3 validatorB3 = new ValidatorB3();

	@Test
	public void test1() {

		assertTrue(validatorB3.isValid("1000000060"));
		assertTrue(validatorB3.isValid("0000000140"));
		assertTrue(validatorB3.isValid("0000000019"));
		assertTrue(validatorB3.isValid("1002798417"));
		assertTrue(validatorB3.isValid("8409915001"));
		assertTrue(validatorB3.isValid("9635000101"));
		assertTrue(validatorB3.isValid("9730200100"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorB3.isValid("9635100101"));
		assertFalse(validatorB3.isValid("9730300100"));

	}
	
}
