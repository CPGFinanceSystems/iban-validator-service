package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class ValidatorB9 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;
		
		if(accountNumber.getLength() == 8) {
		
			validator = new ValidatorB9V1();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());		
		}
	
		if(accountNumber.getLength() == 7) {
			
			validator = new ValidatorB9V2();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		return false;	
	}

}
