package com.hph.finance.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator22Test {

	private Validator22 validator22 = new Validator22();

	@Test
	public void test1() {

		assertTrue(validator22.isValid("2394871426"));
		assertTrue(validator22.isValid("4218461950"));
		assertTrue(validator22.isValid("7352569148"));
	}

	@Test
	public void test2() {

		assertFalse(validator22.isValid("5127485166"));
		assertFalse(validator22.isValid("8738142564"));
		assertFalse(validator22.isValid("0328705282"));
		assertFalse(validator22.isValid("9024675131"));
	}
}
