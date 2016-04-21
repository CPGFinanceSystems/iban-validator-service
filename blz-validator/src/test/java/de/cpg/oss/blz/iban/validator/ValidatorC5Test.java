package de.cpg.oss.blz.iban.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorC5Test {

	private ValidatorC5 validatorC5 = new ValidatorC5();

	@Test
	public void test1() {


		assertTrue(validatorC5.isValid("0300020050"));
		assertTrue(validatorC5.isValid("0300566000"));
		assertTrue(validatorC5.isValid("1000061378"));
		assertTrue(validatorC5.isValid("1000061412"));
		assertTrue(validatorC5.isValid("4450164064"));
		assertTrue(validatorC5.isValid("4863476104"));
		assertTrue(validatorC5.isValid("5000000028"));
		assertTrue(validatorC5.isValid("5000000391"));
		assertTrue(validatorC5.isValid("6450008149"));
		assertTrue(validatorC5.isValid("6800001016"));
		assertTrue(validatorC5.isValid("9000100012"));
		assertTrue(validatorC5.isValid("9000210017"));
		assertTrue(validatorC5.isValid("3060188103"));
		assertTrue(validatorC5.isValid("3070402023"));
	}

	
	@Test
	public void test2() {
		
		assertFalse(validatorC5.isValid("1000061457"));
		assertFalse(validatorC5.isValid("1000061498"));
		assertFalse(validatorC5.isValid("4864446015"));
		assertFalse(validatorC5.isValid("4865038012"));
		assertFalse(validatorC5.isValid("5000001028"));
		assertFalse(validatorC5.isValid("5000001075"));
		assertFalse(validatorC5.isValid("6450008150"));
		assertFalse(validatorC5.isValid("6542812818"));
		assertFalse(validatorC5.isValid("9000110012"));
		assertFalse(validatorC5.isValid("9000300310"));
	}
	
}
