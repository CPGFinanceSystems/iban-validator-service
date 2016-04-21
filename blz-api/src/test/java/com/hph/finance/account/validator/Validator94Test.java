package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator94Test {

	private Validator94 validator94 = new Validator94();

	@Test
	public void test1() {

		assertTrue(validator94.isValid("6782533003"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validator94.isValid("6782533002"));
	}
	
}
