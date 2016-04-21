package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class ValidatorA6 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;
		if(extract(accountNumber.getZeroFilled(), 2).equals("8")) {
			validator = new Validator00();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		validator = new Validator01();
		return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());		
	}
}
