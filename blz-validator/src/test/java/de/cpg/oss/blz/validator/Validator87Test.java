package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator87Test {

	private Validator87 validator87 = new Validator87();

	@Test
	public void test1() {

		assertTrue(validator87.isValid("0000000406"));
		assertTrue(validator87.isValid("0000051768"));
		assertTrue(validator87.isValid("0010701590"));
		assertTrue(validator87.isValid("0010720185"));
		assertTrue(validator87.isValid("0000100005"));
		assertTrue(validator87.isValid("0000393814"));
		assertTrue(validator87.isValid("0000950360"));
		assertTrue(validator87.isValid("3199500501"));
	}

	@Test
	public void test2() {
		
		assertFalse(validator87.isValid("0000300406"));
		assertFalse(validator87.isValid("0299351768"));
		assertFalse(validator87.isValid("0010441590"));
		assertFalse(validator87.isValid("9910225144"));
		assertFalse(validator87.isValid("0880155399"));
		assertFalse(validator87.isValid("0045039384"));
		assertFalse(validator87.isValid("0006650360"));
		assertFalse(validator87.isValid("3669500501"));		
	}

}
