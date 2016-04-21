package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorB9Test {

	private ValidatorB9 validatorB8 = new ValidatorB9();

	@Test
	public void test1() {

		assertTrue(validatorB8.isValid("87920187"));
		assertTrue(validatorB8.isValid("41203755"));
		assertTrue(validatorB8.isValid("81069577"));
		assertTrue(validatorB8.isValid("61287958"));
		assertTrue(validatorB8.isValid("58467232"));

		assertTrue(validatorB8.isValid("7125633"));
		assertTrue(validatorB8.isValid("1253657"));
		assertTrue(validatorB8.isValid("4353631"));
	}

	
	@Test
	public void test2() {

		assertFalse(validatorB8.isValid("87920181"));
		assertFalse(validatorB8.isValid("41203752"));
		assertFalse(validatorB8.isValid("81069573"));
		assertFalse(validatorB8.isValid("61287954"));
		assertFalse(validatorB8.isValid("58467235"));

		assertFalse(validatorB8.isValid("7125636"));
		assertFalse(validatorB8.isValid("1253659"));
		assertFalse(validatorB8.isValid("4353638"));	
	}
	
}
