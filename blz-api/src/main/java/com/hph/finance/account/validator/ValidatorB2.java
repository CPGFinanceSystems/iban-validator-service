package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class ValidatorB2 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		
		int first = extractAsInt(accountNumber.getZeroFilled(), 1);
		
		Validator validator;
		if(first >= 0 && first <= 7) {
			validator = new Validator02();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		} else {
			validator = new Validator00();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());			
		}		
	}
}
