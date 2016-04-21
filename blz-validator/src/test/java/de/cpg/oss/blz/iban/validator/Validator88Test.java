package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator88Test {

	private Validator88 validator88 = new Validator88();

	@Test
	public void test1() {

		assertTrue(validator88.isValid("2525259"));
		assertTrue(validator88.isValid("1000500"));
		assertTrue(validator88.isValid("90013000"));
		assertTrue(validator88.isValid("92525253"));
		assertTrue(validator88.isValid("99913003"));
	}

	@Test
	public void test2() {	
		
		assertFalse(validator88.isValid("2525253"));
		assertFalse(validator88.isValid("1000502"));
		assertFalse(validator88.isValid("90013004"));
		assertFalse(validator88.isValid("92525252"));
		assertFalse(validator88.isValid("99913006"));		
	}

}
