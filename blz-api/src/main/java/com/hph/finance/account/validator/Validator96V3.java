package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class Validator96V3 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		return accountNumber.getRawNumberAsLong() >= 1300000 && 
				accountNumber.getRawNumberAsLong() <= 99399999;
	}

}
