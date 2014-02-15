package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus=10, weights={3, 1, 7, 3, 1, 7, 3}, posFrom=3, posTo=9, posChecksum=10)
public class Validator98 extends Validator01 {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		if(!super.validate(accountNumber)) {
			Validator validator = new Validator32();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());			
		}
		
		return true;
	}
}
