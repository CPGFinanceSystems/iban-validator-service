package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorD4Test {

	private ValidatorD4 validatorD4 = new ValidatorD4();

	@Test
	public void test1() {


		assertTrue(validatorD4.isValid("1112048219"));
		assertTrue(validatorD4.isValid("2024601814"));
		assertTrue(validatorD4.isValid("3000005012"));
		assertTrue(validatorD4.isValid("4143406984"));
		assertTrue(validatorD4.isValid("5926485111"));
		assertTrue(validatorD4.isValid("6286304975"));
		assertTrue(validatorD4.isValid("7900256617"));
		assertTrue(validatorD4.isValid("8102228628"));
		assertTrue(validatorD4.isValid("9002364588"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorD4.isValid("0359432843"));
		assertFalse(validatorD4.isValid("1000062023"));
		assertFalse(validatorD4.isValid("2204271250"));
		assertFalse(validatorD4.isValid("3051681017"));
		assertFalse(validatorD4.isValid("4000123456"));
		assertFalse(validatorD4.isValid("5212744564"));
		assertFalse(validatorD4.isValid("6286420010"));
		assertFalse(validatorD4.isValid("7859103459"));
		assertFalse(validatorD4.isValid("8003306026"));
		assertFalse(validatorD4.isValid("9916524534"));
	}
	
}
