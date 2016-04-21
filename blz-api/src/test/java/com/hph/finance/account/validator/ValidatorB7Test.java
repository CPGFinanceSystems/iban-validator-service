package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorB7Test {

	private ValidatorB7 validatorB7 = new ValidatorB7();

	@Test
	public void test1() {

		assertTrue(validatorB7.isValid("0700001529"));
		assertTrue(validatorB7.isValid("0730000019"));
		assertTrue(validatorB7.isValid("0001001008"));
		assertTrue(validatorB7.isValid("0001057887"));
		assertTrue(validatorB7.isValid("0001007222"));
		assertTrue(validatorB7.isValid("0810011825"));
		assertTrue(validatorB7.isValid("0800107653"));
		assertTrue(validatorB7.isValid("0005922372"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorB7.isValid("0001057886"));
		assertFalse(validatorB7.isValid("0003815570"));
		assertFalse(validatorB7.isValid("0005620516"));
		assertFalse(validatorB7.isValid("0740912243"));
		assertFalse(validatorB7.isValid("0893524479"));
	}
	
}
