package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator85Test {

	private Validator85 validator85 = new Validator85();

	@Test
	public void test1() {

		assertTrue(validator85.isValid("0001156071"));
		assertTrue(validator85.isValid("0001156136"));
		assertTrue(validator85.isValid("0000156078"));
		assertTrue(validator85.isValid("0000156071"));
		assertTrue(validator85.isValid("3199100002"));
	}

	@Test
	public void test2() {

		assertFalse(validator85.isValid("0001156075"));
		assertFalse(validator85.isValid("0001156134"));
		assertFalse(validator85.isValid("0000156073"));
		assertFalse(validator85.isValid("0000156076"));
		assertFalse(validator85.isValid("3199100007"));
	}

}
