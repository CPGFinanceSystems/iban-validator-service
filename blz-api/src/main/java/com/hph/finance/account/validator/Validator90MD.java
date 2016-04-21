package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 9, weights = {2, 3, 4, 5, 6}, posFrom = 5, posTo = 9, posChecksum = 10)
public class Validator90MD extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		if(accountNumber.getChecksumAsInt() == 9) {
			return false;
		}
		
		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int rest = sum % modulus;
		int checksum = modulus - rest;
	
		if(rest == 0) {
			checksum = 0;
		}
		
		return checksum == accountNumber.getChecksumAsInt();
	}
}
