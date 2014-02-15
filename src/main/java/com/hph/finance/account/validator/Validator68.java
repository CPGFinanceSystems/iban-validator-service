package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 }, posFrom = -7, posTo = -2, posChecksum = -1)
public class Validator68 extends Validator00 {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int length = accountNumber.getRawNumber().length();

		if (length == 10) {

			return super.validate(accountNumber);

		} else if (length >= 6 && length <= 9) {

			if (accountNumber.getRawNumberAsLong() >= 400000000
					&& accountNumber.getRawNumberAsLong() <= 499999999) {
				return true;
			}

			Validator validator = new Validator68A();
			if (!validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber())) {

				validator = new Validator68B();
				return validator.isValid(accountNumber.getRawNumber(),
						accountNumber.getBankNumber());
			}

			return true;
		}

		return false;
	}
}
