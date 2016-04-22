package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorD1Test {

	private ValidatorD1 validatorD1 = new ValidatorD1();

	@Test
	public void test1() {


		assertTrue(validatorD1.isValid("0082012203"));
		assertTrue(validatorD1.isValid("1452683581"));
		assertTrue(validatorD1.isValid("2129642505"));
		assertTrue(validatorD1.isValid("3002000027"));
		assertTrue(validatorD1.isValid("4230001407"));
		assertTrue(validatorD1.isValid("5000065514"));
		assertTrue(validatorD1.isValid("6001526215"));
		assertTrue(validatorD1.isValid("9000430223"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorD1.isValid("0000260986"));
		assertFalse(validatorD1.isValid("1062813622"));
		assertFalse(validatorD1.isValid("2256412314"));
		assertFalse(validatorD1.isValid("3012084101"));
		assertFalse(validatorD1.isValid("4006003027"));
		assertFalse(validatorD1.isValid("5814500990"));
		assertFalse(validatorD1.isValid("6128462594"));
		assertFalse(validatorD1.isValid("7000062025"));
		assertFalse(validatorD1.isValid("8003306026"));
		assertFalse(validatorD1.isValid("9000641509"));
	}
	
}
