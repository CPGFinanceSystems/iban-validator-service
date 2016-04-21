package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class Validator76 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator = new Validator76E1();

		if (!validator.isValid(accountNumber.getRawNumber(),
				accountNumber.getBankNumber())) {

			return validator.isValid(
					extract(accountNumber.getZeroFilled(), 3, -1) + "00",
					accountNumber.getBankNumber());
		}

		return true;
	}
}
