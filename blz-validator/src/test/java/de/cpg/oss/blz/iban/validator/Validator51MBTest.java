package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator51MBTest {

	private Validator51MB validator51MB = new Validator51MB();

	@Test
	public void test1() {

		assertTrue(validator51MB.isValid("0000156078"));
	}

	@Test
	public void test2() {

		assertFalse(validator51MB.isValid("0000156075"));
	}
}
