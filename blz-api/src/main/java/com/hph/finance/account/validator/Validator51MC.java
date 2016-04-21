package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 7, weights = { 2, 3, 4, 5, 6 }, posFrom = 5, posTo = 9, posChecksum = 10)
public class Validator51MC extends Validator33 {

	public boolean validateException(PreparedAccountNumber accountNumber) {

		Validator validator;
		validator = new Validator51MCA1();
		if (!validator.isValid(accountNumber.getRawNumber())) {

			validator = new Validator51MCA2();
			return validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber());
		}

		return true;
	}

	protected boolean validate(PreparedAccountNumber accountNumber) {

		int tenth = Integer
				.parseInt(extract(accountNumber.getZeroFilled(), 10));

		if (tenth > 6 && tenth < 10) {
			return false;
		}

		int third = Integer.parseInt(extract(accountNumber.getZeroFilled(), 3));
		if (third == 9) {
			return validateException(accountNumber);
		}

		return super.validate(accountNumber);
	}
}
