package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorD0Test {

	private ValidatorD0 validatorD0 = new ValidatorD0();

	@Test
	public void test1() {


		assertTrue(validatorD0.isValid("6100272324"));
		assertTrue(validatorD0.isValid("6100273479"));
		assertTrue(validatorD0.isValid("5700000000"));
		assertTrue(validatorD0.isValid("5799999999"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorD0.isValid("6100272885"));
		assertFalse(validatorD0.isValid("6100273377"));
		assertFalse(validatorD0.isValid("6100274012"));
	}
	
}
