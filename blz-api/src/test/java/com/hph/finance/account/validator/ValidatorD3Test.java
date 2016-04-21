package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorD3Test {

	private ValidatorD3 validatorD3 = new ValidatorD3();

	@Test
	public void test1() {


		assertTrue(validatorD3.isValid("1600169591"));
		assertTrue(validatorD3.isValid("1600189151"));
		assertTrue(validatorD3.isValid("1800084079"));
		assertTrue(validatorD3.isValid("6019937007"));
		assertTrue(validatorD3.isValid("6021354007"));
		assertTrue(validatorD3.isValid("6030642006"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorD3.isValid("6025017009"));
		assertFalse(validatorD3.isValid("6028267003"));
		assertFalse(validatorD3.isValid("6019835001"));
	}
	
}
