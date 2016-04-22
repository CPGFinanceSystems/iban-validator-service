package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator89Test {

	private Validator89 validator89 = new Validator89();

	@Test
	public void test1() {

		assertTrue(validator89.isValid("1098506"));
		assertTrue(validator89.isValid("32028008"));
		assertTrue(validator89.isValid("218433000"));
	}

	@Test
	public void test2() {	
		
		assertFalse(validator89.isValid("1098503"));
		assertFalse(validator89.isValid("32028003"));
		assertFalse(validator89.isValid("218433003"));		
	}
}
