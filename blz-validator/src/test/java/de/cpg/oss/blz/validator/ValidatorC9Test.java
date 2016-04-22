package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorC9Test {

	private ValidatorC9 validatorC9 = new ValidatorC9();

	@Test
	public void test1() {


		assertTrue(validatorC9.isValid("3456789019"));
		assertTrue(validatorC9.isValid("5678901231"));
		assertTrue(validatorC9.isValid("0123456789"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorC9.isValid("1234567890"));
		assertFalse(validatorC9.isValid("9012345678"));
	}
	
}
