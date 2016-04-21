package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class ValidatorA4V4 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator = new Validator93();
		return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
	}

}
