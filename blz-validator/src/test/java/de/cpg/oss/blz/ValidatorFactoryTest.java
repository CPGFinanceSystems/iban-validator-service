package de.cpg.oss.blz;

import static org.junit.Assert.*;

import de.cpg.oss.blz.validator.Validator00;
import de.cpg.oss.blz.validator.Validator01;
import de.cpg.oss.blz.validator.Validator02;
import org.junit.Test;

import de.cpg.oss.blz.ValidatorFactory;

public class ValidatorFactoryTest {

	@Test
	public void test1() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {

		assertEquals(Validator00.class, ValidatorFactory.factory("00")
				.getClass());
		assertEquals(Validator01.class, ValidatorFactory.factory("01")
				.getClass());
		assertEquals(Validator02.class, ValidatorFactory.factory("02")
				.getClass());
	}
}
