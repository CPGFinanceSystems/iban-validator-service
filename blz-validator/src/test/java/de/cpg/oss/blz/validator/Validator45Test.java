package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator45Test {

	private Validator45 validator45 = new Validator45();

	@Test
	public void test1() {

		assertTrue(validator45.isValid("3545343232"));
		assertTrue(validator45.isValid("4013410024"));

		assertTrue(validator45.isValid("0994681254"));
		assertTrue(validator45.isValid("0000012340"));
		assertTrue(validator45.isValid("1000199999"));
		assertTrue(validator45.isValid("0100114240"));
	}

	@Test
	public void test2() {

		assertFalse(validator45.isValid("3545343235"));
		assertFalse(validator45.isValid("4013410026"));

		assertFalse(validator45.isValid("1994681254"));
		assertFalse(validator45.isValid("2000312340"));
		assertFalse(validator45.isValid("3000499999"));
		assertFalse(validator45.isValid("4100514240"));
	}
}
