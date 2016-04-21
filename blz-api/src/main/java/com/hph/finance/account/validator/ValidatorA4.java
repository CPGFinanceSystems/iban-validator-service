package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class ValidatorA4 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;
		
		if(extract(accountNumber.getZeroFilled(), 3, 4).equals("99")) {
			
			validator = new ValidatorA4V3();
			if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
				validator = new ValidatorA4V4();
				return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());		
			}
			
			return true;
			
		} else {
			
			validator = new ValidatorA4V1();
			if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
				validator = new ValidatorA4V2();
				if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
					validator = new ValidatorA4V4();
					return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());		
				}		
			}
			
			return true;
		}
		
	}

}
