package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 8 })
public class Validator69 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Long number = accountNumber.getRawNumberAsLong();

		if (number >= 9300000000L && number <= 9399999999L) {
			return true;
		} else if (number >= 9700000000L && number <= 9799999999L) {
			Validator validator = new Validator69V2();
			return validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber());
		}

		Validator validator = new Validator69V1();
		if (!validator.isValid(accountNumber.getRawNumber(),
				accountNumber.getBankNumber())) {
			validator = new Validator69V2();
			return validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber());
		}

		return true;
	}

}
