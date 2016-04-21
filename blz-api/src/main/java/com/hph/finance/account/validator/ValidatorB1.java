package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class ValidatorB1 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator = new Validator05();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			
			validator = new Validator01();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		return true;
	}

}
