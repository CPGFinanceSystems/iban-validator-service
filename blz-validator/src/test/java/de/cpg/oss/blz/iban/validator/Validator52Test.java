package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator52Test {

	private Validator52 validator52 = new Validator52();

	@Test
	public void test1() {

		assertTrue(validator52.isValid("43001500", "13051172"));
		// TODO: Check this number
		// assertTrue(validator52.isValid("48726458", "13051172"));
	}

	@Test
	public void test2() {

		assertFalse(validator52.isValid("45001500", "13051172"));
		assertFalse(validator52.isValid("82335729", "13051172"));
		assertFalse(validator52.isValid("29837521", "13051172"));
	}
}
