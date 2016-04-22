package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorC6Test {

	private ValidatorC6 validatorC6 = new ValidatorC6();

	@Test
	public void test1() {


		assertTrue(validatorC6.isValid("0000065516"));
		assertTrue(validatorC6.isValid("0203178249"));
		assertTrue(validatorC6.isValid("1031405209"));
		assertTrue(validatorC6.isValid("1082012201"));
		assertTrue(validatorC6.isValid("2003455189"));
		assertTrue(validatorC6.isValid("2004001016"));
		assertTrue(validatorC6.isValid("3110150986"));
		assertTrue(validatorC6.isValid("3068459207"));
		assertTrue(validatorC6.isValid("5035105948"));
		assertTrue(validatorC6.isValid("5286102149"));
		assertTrue(validatorC6.isValid("6028426119"));
		assertTrue(validatorC6.isValid("6861001755"));
		assertTrue(validatorC6.isValid("7008199027"));
		assertTrue(validatorC6.isValid("7002000023"));
		assertTrue(validatorC6.isValid("9000430223"));
		assertTrue(validatorC6.isValid("9000781153"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorC6.isValid("0525111212"));
		assertFalse(validatorC6.isValid("0091423614"));
		assertFalse(validatorC6.isValid("1082311275"));
		assertFalse(validatorC6.isValid("1000118821"));
		assertFalse(validatorC6.isValid("2004306518"));
		assertFalse(validatorC6.isValid("2016001206"));
		assertFalse(validatorC6.isValid("3462816371"));
		assertFalse(validatorC6.isValid("3622548632"));
		assertFalse(validatorC6.isValid("4232300145"));
		assertFalse(validatorC6.isValid("4000456126"));
		assertFalse(validatorC6.isValid("5002684526"));
		assertFalse(validatorC6.isValid("5564123850"));
		assertFalse(validatorC6.isValid("6295473774"));
		assertFalse(validatorC6.isValid("6640806317"));
		assertFalse(validatorC6.isValid("7000062022"));
		assertFalse(validatorC6.isValid("7006003027"));
		assertFalse(validatorC6.isValid("8348300005"));
		assertFalse(validatorC6.isValid("8654216984"));
		assertFalse(validatorC6.isValid("9000641509"));
		assertFalse(validatorC6.isValid("9000260986"));
	}
	
}
