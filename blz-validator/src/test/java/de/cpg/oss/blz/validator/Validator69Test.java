package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator69Test {

	private Validator69 validator69 = new Validator69();

	@Test
	public void test1() {

		assertTrue(validator69.isValid("9721134869"));
		assertTrue(validator69.isValid("1234567900"));
		assertTrue(validator69.isValid("1234567006"));
	}

	@Test
	public void test2() {

		assertFalse(validator69.isValid("400000000"));
		assertFalse(validator69.isValid("499999999"));
		assertFalse(validator69.isValid("499999998"));
	}

}
