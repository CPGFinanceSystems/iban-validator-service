package com.hph.finance.account.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hph.finance.account.ValidatorFactory;

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
