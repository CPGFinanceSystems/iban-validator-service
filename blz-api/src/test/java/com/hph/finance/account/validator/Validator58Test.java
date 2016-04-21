package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator58Test {

	private Validator58 validator58 = new Validator58();

	@Test
	public void test1() {

		assertTrue(validator58.isValid("1800881120"));
		assertTrue(validator58.isValid("9200654108"));
		assertTrue(validator58.isValid("1015222224"));
		assertTrue(validator58.isValid("3703169668"));
	}

	@Test
	public void test2() {

		assertFalse(validator58.isValid("1800841120"));
		assertFalse(validator58.isValid("9200674108"));
		assertFalse(validator58.isValid("1015262224"));
		assertFalse(validator58.isValid("3703139668"));
	}

}
