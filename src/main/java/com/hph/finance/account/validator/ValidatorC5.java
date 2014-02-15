package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class ValidatorC5 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		int first = extractAsInt(accountNumber.getZeroFilled(), 1);
		int length = accountNumber.getLength();
		long number = accountNumber.getRawNumberAsLong();
		
		Validator validator;
		
		if( (length == 6 && number >= 100000 && number <= 899999) || 
			(length == 9 && number >= 100000000 && number <= 899999999) ) {
			
			validator = new Validator75();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		if( (length == 10 &&
				(first == 1 || first == 4 || first == 5 || first == 6 || first == 9) &&
				((number >= 1000000000L && number <= 1999999999L) || 
				(number >= 4000000000L && number <= 6999999999L) ||
				(number >= 9000000000L && number <= 9999999999L))) ) {
			
			validator = new Validator29();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		if( (length == 10 &&
				first == 3 &&
				number >= 3000000000L && 
				number <= 3999999999L)
			) {
			
			validator = new Validator00();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		if( (length == 8 && number >= 30000000L && number <= 59999999L) ||
			(length == 10 &&
			(extractAsInt(accountNumber.getTrimmed(), 1, 2) == 70 || 
			extractAsInt(accountNumber.getTrimmed(), 1, 2) == 58) &&
			((number >= 7000000000L && number <= 7099999999L) ||
			(number >= 8500000000L && number <= 8599999999L))) ) {
			
			validator = new Validator09();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}	
		
		return false;
	}
}
