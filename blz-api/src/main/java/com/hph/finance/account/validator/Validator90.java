package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class Validator90 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Validator validator;
		
		if(extract(accountNumber.getZeroFilled(), 3).equals("9")) {
			validator = new Validator90MF();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		validator = new Validator90MA();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			validator = new Validator90MB();
			if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
				validator = new Validator90MC();
				if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
					validator = new Validator90MD();
					if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
						validator = new Validator90ME();
						return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
					}				
				}			
			}		
		}
		
		return true;
	}

}
