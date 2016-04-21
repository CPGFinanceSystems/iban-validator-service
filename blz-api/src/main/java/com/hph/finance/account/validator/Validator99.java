package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus=11, weights={2, 3, 4, 5, 6, 7, 2, 3, 4})
public class Validator99 extends Validator06 {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		if(accountNumber.getRawNumberAsLong() >= 396000000 && accountNumber.getRawNumberAsLong() <= 499999999) {
			return true;
		}
		
		return super.validate(accountNumber);
	}
}
