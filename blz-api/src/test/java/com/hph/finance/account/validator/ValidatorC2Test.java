package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorC2Test {

	private ValidatorC2 validatorC2 = new ValidatorC2();

	@Test
	public void test1() {


		assertTrue(validatorC2.isValid("2394871426"));
		assertTrue(validatorC2.isValid("4218461950"));
		assertTrue(validatorC2.isValid("7352569148"));

		assertTrue(validatorC2.isValid("5127485166"));
		assertTrue(validatorC2.isValid("8738142564"));
	}

	
	@Test
	public void test2() {

		assertFalse(validatorC2.isValid("0328705282"));
		assertFalse(validatorC2.isValid("9024675131"));
	}
	
}
