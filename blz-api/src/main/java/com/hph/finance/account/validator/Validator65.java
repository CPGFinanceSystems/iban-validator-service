package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class Validator65 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;

		if (extractAsInt(accountNumber.getZeroFilled(), 9) == 9) {
			validator = new Validator65B();
		} else {
			validator = new Validator65A();
		}

		return validator.isValid(accountNumber.getRawNumber());
	}
}
