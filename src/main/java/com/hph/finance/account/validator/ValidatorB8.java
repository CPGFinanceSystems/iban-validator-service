package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class ValidatorB8 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		Validator validator = new Validator20();
		if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
			validator = new Validator29();
			if(!validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber())) {
				
				if( (accountNumber.getRawNumberAsLong() >= 5100000000L && accountNumber.getRawNumberAsLong() <= 5999999999L) ||
						(accountNumber.getRawNumberAsLong() >= 9010000000L && accountNumber.getRawNumberAsLong() <= 9109999999L)
					) {
					
					validator = new Validator09();
					return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
				}
				
				return false;
			}		
		}
		
		return true;
	}

}
