package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator33Test {

	private Validator33 validator33 = new Validator33();

	@Test
	public void test1() {

		assertTrue(validator33.isValid("48658"));
		assertTrue(validator33.isValid("84956"));
	}

	@Test
	public void test2() {

		assertFalse(validator33.isValid("48653"));
		assertFalse(validator33.isValid("84952"));
	}
}
