package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator77Test {

	private Validator77 validator77 = new Validator77();

	@Test
	public void test1() {

		assertTrue(validator77.isValid("47678"));
		assertTrue(validator77.isValid("47671"));
		assertTrue(validator77.isValid("10338"));
		assertTrue(validator77.isValid("13844"));
		assertTrue(validator77.isValid("65354"));
		assertTrue(validator77.isValid("69258"));
	}

	@Test
	public void test2() {

		assertFalse(validator77.isValid("47674"));
		assertFalse(validator77.isValid("47673"));
		assertFalse(validator77.isValid("10334"));
		assertFalse(validator77.isValid("13847"));
		assertFalse(validator77.isValid("65355"));
		assertFalse(validator77.isValid("69259"));
	}

}
