package com.hph.finance.account;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatorData {

	int modulus() default 10;

	int[] weights() default {};

	int length() default 10;

	int posFrom() default 1;

	int posTo() default -2;

	int posChecksum() default -1;

	int[] crossSumIndexes() default {};

	int[] transTable() default {};

	int[] transTableRows() default {};

	int transTableWidth() default 10;
}