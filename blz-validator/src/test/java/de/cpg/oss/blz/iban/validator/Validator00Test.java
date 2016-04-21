package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator00Test {

	private Validator00 validator00 = new Validator00();

	@Test
	public void test1() {

		assertTrue(validator00.isValid("9290701"));
		assertTrue(validator00.isValid("539290858"));
		assertTrue(validator00.isValid("1501824"));
		assertTrue(validator00.isValid("1501832"));
	}

	@Test
	public void test2() {

		assertFalse(validator00.isValid("9290705"));
		assertFalse(validator00.isValid("539290857"));
		assertFalse(validator00.isValid("1501829"));
		assertFalse(validator00.isValid("1501833"));
	}
}
