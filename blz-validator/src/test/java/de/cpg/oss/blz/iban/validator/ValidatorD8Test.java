package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorD8Test {

	private ValidatorD8 validatorD8 = new ValidatorD8();

	@Test
	public void test1() {


		assertTrue(validatorD8.isValid("1403414848"));
		assertTrue(validatorD8.isValid("6800000439"));
		assertTrue(validatorD8.isValid("6899999954"));
		assertTrue(validatorD8.isValid("0010000000"));
		assertTrue(validatorD8.isValid("0099999999"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorD8.isValid("3012084101"));
		assertFalse(validatorD8.isValid("1062813622"));
		assertFalse(validatorD8.isValid("0000260986"));
	}
	
}
