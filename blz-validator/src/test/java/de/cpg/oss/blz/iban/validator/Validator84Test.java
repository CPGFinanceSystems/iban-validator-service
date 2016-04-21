package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Validator84Test {

	private Validator84 validator84 = new Validator84();

	@Test
	public void test1() {

		assertTrue(validator84.isValid("100005"));
		assertTrue(validator84.isValid("393814"));
		assertTrue(validator84.isValid("950360"));
	}

	@Test
	public void test2() {

		assertFalse(validator84.isValid("100003"));
		assertFalse(validator84.isValid("393812"));
		assertFalse(validator84.isValid("950361"));
	}

}
