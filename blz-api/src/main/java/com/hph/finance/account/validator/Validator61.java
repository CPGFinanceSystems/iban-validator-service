package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class Validator61 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;

		if (extractAsInt(accountNumber.getZeroFilled(), 9) == 8) {
			validator = new Validator61B();
		} else {
			validator = new Validator61A();
		}

		return validator.isValid(accountNumber.getRawNumber());
	}

}
