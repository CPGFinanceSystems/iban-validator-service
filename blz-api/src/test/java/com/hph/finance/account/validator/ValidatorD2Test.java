package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorD2Test {

	private ValidatorD2 validatorD2 = new ValidatorD2();

	@Test
	public void test1() {


		assertTrue(validatorD2.isValid("189912137"));
		assertTrue(validatorD2.isValid("235308215"));
		assertTrue(validatorD2.isValid("4455667784"));
		assertTrue(validatorD2.isValid("1234567897"));
		assertTrue(validatorD2.isValid("51181008"));
		assertTrue(validatorD2.isValid("71214205"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorD2.isValid("6414241"));
		assertFalse(validatorD2.isValid("179751314"));
	}
	
}
