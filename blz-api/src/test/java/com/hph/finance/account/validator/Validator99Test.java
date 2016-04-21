package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator99Test {

	private Validator99 validator99 = new Validator99();

	@Test
	public void test1() {

		assertTrue(validator99.isValid("0068007003"));
		assertTrue(validator99.isValid("0847321750"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validator99.isValid("0068007004"));
		assertFalse(validator99.isValid("0847321752"));
	}
	
}
