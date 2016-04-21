package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorB8Test {

	private ValidatorB8 validatorB8 = new ValidatorB8();

	@Test
	public void test1() {

		assertTrue(validatorB8.isValid("0734192657"));
		assertTrue(validatorB8.isValid("6932875274"));
		assertTrue(validatorB8.isValid("3145863029"));
		assertTrue(validatorB8.isValid("2938692523"));
		assertTrue(validatorB8.isValid("5100000000"));
		assertTrue(validatorB8.isValid("5999999999"));
		assertTrue(validatorB8.isValid("9010000000"));
		assertTrue(validatorB8.isValid("9109999999"));
	}

	
	@Test
	public void test2() {

		assertFalse(validatorB8.isValid("0132572975"));
		assertFalse(validatorB8.isValid("9000412340"));
		assertFalse(validatorB8.isValid("9310305011"));
		
		assertFalse(validatorB8.isValid("0132572975"));
		assertFalse(validatorB8.isValid("9310305011"));		
	}
	
}
