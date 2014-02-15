package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 })
public class Validator78 extends Validator00 {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (accountNumber.getLength() == 8) {
			return false;
		}

		return super.validate(accountNumber);
	}
}
