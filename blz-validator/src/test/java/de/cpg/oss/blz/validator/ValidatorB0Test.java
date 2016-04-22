package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorB0Test {

	private ValidatorB0 validatorB0 = new ValidatorB0();

	@Test
	public void test1() {

		assertTrue(validatorB0.isValid("1197423162"));
		assertTrue(validatorB0.isValid("1000000606"));
		assertTrue(validatorB0.isValid("1000000406"));
		assertTrue(validatorB0.isValid("1035791538"));
		assertTrue(validatorB0.isValid("1126939724"));
		assertTrue(validatorB0.isValid("1197423460"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorB0.isValid("1000000405"));
		assertFalse(validatorB0.isValid("1035791539"));
		assertFalse(validatorB0.isValid("1035791533"));
		assertFalse(validatorB0.isValid("1126939723"));
		assertFalse(validatorB0.isValid("1197423463"));
		
		// TODO: Check this numbers
		//assertFalse(validatorB0.isValid("8035791532"));
		//assertFalse(validatorB0.isValid("535791830"));
		//assertFalse(validatorB0.isValid("51234901"));
	}
	
}
