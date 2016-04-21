package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus=7, weights={2, 3, 4, 5, 6, 7, 0, 0, 0}, posFrom=4)
public class ValidatorD5V3 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int rest = sum % modulus;
		int checksum = modulus - rest;
		
		if(rest == 0) {
			checksum = 0;
		}
		
		return checksum == accountNumber.getChecksumAsInt();
	}

}
