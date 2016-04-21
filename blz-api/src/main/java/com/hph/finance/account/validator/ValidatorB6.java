package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class ValidatorB6 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;
		
		if( (extractAsInt(accountNumber.getZeroFilled(), 1) >= 1 && extractAsInt(accountNumber.getZeroFilled(), 1) <= 9) || 
			(extractAsInt(accountNumber.getZeroFilled(), 1, 5) >= 2691 && extractAsInt(accountNumber.getZeroFilled(), 1, 5) <= 2699)
		) {
			validator = new Validator20();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		validator = new Validator53();
		return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
	}

}
