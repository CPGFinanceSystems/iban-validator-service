package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorC1Test {

	private ValidatorC1 validatorC1 = new ValidatorC1();

	@Test
	public void test1() {


		assertTrue(validatorC1.isValid("0446786040"));
		assertTrue(validatorC1.isValid("0478046940"));
		assertTrue(validatorC1.isValid("0701625830"));
		assertTrue(validatorC1.isValid("0701625840"));
		assertTrue(validatorC1.isValid("0882095630"));

		assertTrue(validatorC1.isValid("5432112349"));
		assertTrue(validatorC1.isValid("5543223456"));
		assertTrue(validatorC1.isValid("5654334563"));
		assertTrue(validatorC1.isValid("5765445670"));
		assertTrue(validatorC1.isValid("5876556788"));
	}

	
	@Test
	public void test2() {

		assertFalse(validatorC1.isValid("5432112341"));
		assertFalse(validatorC1.isValid("5543223458"));
		assertFalse(validatorC1.isValid("5654334565"));
		assertFalse(validatorC1.isValid("5765445672"));
		assertFalse(validatorC1.isValid("5876556780"));
	}
	
}
