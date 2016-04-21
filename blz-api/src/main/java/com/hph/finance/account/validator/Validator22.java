package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 3, 1, 3, 1, 3, 1, 3, 1, 3 })
public class Validator22 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeftLast(accountNumber.getExtracted(), weights);
		int rest = (sum % modulus);
		int checksum = modulus - rest;

		if(rest == 0) {
			checksum = 0;
		}
		
		return checksum == accountNumber.getChecksumAsInt();
	}
}
