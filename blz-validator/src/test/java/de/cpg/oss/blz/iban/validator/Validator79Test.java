package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator79Test {

	private Validator79 validator79 = new Validator79();

	@Test
	public void test1() {

		assertTrue(validator79.isValid("3230012688"));
		assertTrue(validator79.isValid("4230028872"));
		assertTrue(validator79.isValid("5440001898"));
		assertTrue(validator79.isValid("6330001063"));
		assertTrue(validator79.isValid("7000149349"));
		assertTrue(validator79.isValid("8000003577"));
		assertTrue(validator79.isValid("1550167850"));
		assertTrue(validator79.isValid("9011200140"));
	}

	@Test
	public void test2() {

		assertFalse(validator79.isValid("3230012622"));
		assertFalse(validator79.isValid("4230028833"));
		assertFalse(validator79.isValid("5440001844"));
		assertFalse(validator79.isValid("6330001065"));
		assertFalse(validator79.isValid("7000149366"));
		assertFalse(validator79.isValid("8000003567"));
		assertFalse(validator79.isValid("1550167888"));
		assertFalse(validator79.isValid("9011200199"));
	}

}
