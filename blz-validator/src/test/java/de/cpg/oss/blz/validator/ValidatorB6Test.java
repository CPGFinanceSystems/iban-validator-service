package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorB6Test {

	private ValidatorB6 validatorB6 = new ValidatorB6();

	@Test
	public void test1() {

		assertTrue(validatorB6.isValid("9110000000"));
		assertTrue(validatorB6.isValid("0269876545"));
		assertTrue(validatorB6.isValid("487310018", "80053782"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorB6.isValid("9111000000"));
		assertFalse(validatorB6.isValid("0269456780"));
		assertFalse(validatorB6.isValid("467310018", "80053762"));
		assertFalse(validatorB6.isValid("477310018", "80053772"));
	}
	
}
