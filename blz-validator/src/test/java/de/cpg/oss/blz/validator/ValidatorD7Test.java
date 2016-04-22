package de.cpg.oss.blz.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorD7Test {

	private ValidatorD7 validatorD7 = new ValidatorD7();

	@Test
	public void test1() {


		assertTrue(validatorD7.isValid("0500018205"));
		assertTrue(validatorD7.isValid("0230103715"));
		assertTrue(validatorD7.isValid("0301000434"));
		assertTrue(validatorD7.isValid("0330035104"));
		assertTrue(validatorD7.isValid("0420001202"));
		assertTrue(validatorD7.isValid("0134637709"));
		assertTrue(validatorD7.isValid("0201005939"));
		assertTrue(validatorD7.isValid("0602006999"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorD7.isValid("0501006102"));
		assertFalse(validatorD7.isValid("0231307867"));
		assertFalse(validatorD7.isValid("0301005331"));
		assertFalse(validatorD7.isValid("0330034104"));
		assertFalse(validatorD7.isValid("0420001302"));
		assertFalse(validatorD7.isValid("0135638809"));
		assertFalse(validatorD7.isValid("0202005939"));
		assertFalse(validatorD7.isValid("0601006977"));
	}
	
}
