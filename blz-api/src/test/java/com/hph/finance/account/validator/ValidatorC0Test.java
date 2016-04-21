package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorC0Test {

	private ValidatorC0 validatorC0 = new ValidatorC0();

	@Test
	public void test1() {

		assertTrue(validatorC0.isValid("43001500", "13051172"));
		assertTrue(validatorC0.isValid("0082335729", "13051172"));
		assertTrue(validatorC0.isValid("0734192657", "13051172"));
		assertTrue(validatorC0.isValid("6932875274", "13051172"));
	}

	
	@Test
	public void test2() {

		assertFalse(validatorC0.isValid("0132572975", "13051172"));
		assertFalse(validatorC0.isValid("3038752371", "13051172"));
	}
	
}
