package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorC4Test {

	private ValidatorC4 validatorC4 = new ValidatorC4();

	@Test
	public void test1() {


		assertTrue(validatorC4.isValid("0000000019"));
		assertTrue(validatorC4.isValid("0000292932"));
		assertTrue(validatorC4.isValid("0000094455"));

		assertTrue(validatorC4.isValid("9000420530"));
		assertTrue(validatorC4.isValid("9000010006"));
		assertTrue(validatorC4.isValid("9000577650"));
	}

	
	@Test
	public void test2() {

		assertFalse(validatorC4.isValid("0000000017"));
		assertFalse(validatorC4.isValid("0000292933"));
		assertFalse(validatorC4.isValid("0000094459"));
		
		assertFalse(validatorC4.isValid("9000726558"));
		assertFalse(validatorC4.isValid("9001733457"));
		assertFalse(validatorC4.isValid("9000732000"));
	}
	
}
