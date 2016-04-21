package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 })
public class Validator08 extends Validator00 {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		Long number = Long.parseLong(accountNumber.getRawNumber());
		if (number < 60000) {
			return false;
		}

		return super.validate(accountNumber);
	}
}
