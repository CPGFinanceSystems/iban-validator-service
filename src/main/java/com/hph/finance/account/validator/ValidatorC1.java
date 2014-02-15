package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class ValidatorC1 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;
		
		if(extractAsInt(accountNumber.getZeroFilled(),1) == 5) {
			
			 validator = new ValidatorC1V2();
			 return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());	
		}
		
		 validator = new Validator17();
		return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());	
	}

}
