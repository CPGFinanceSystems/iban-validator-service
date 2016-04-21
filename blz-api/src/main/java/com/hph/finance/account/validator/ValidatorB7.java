package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class ValidatorB7 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
	
		Validator validator;
		
		if( (accountNumber.getRawNumberAsLong() >= 1000000 && accountNumber.getRawNumberAsLong() <= 5999999) ||
			(accountNumber.getRawNumberAsLong() >= 700000000 && accountNumber.getRawNumberAsLong() <= 899999999)
		) {
			validator = new Validator01();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		validator = new Validator09();
		return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());		
	}

}
