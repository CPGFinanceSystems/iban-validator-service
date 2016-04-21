package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 0, 0, 7 }, posFrom = 2, posTo = 9)
public class Validator66 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int rest = sum % modulus;
		int checksum = modulus - rest;

		if (rest == 0) {
			checksum = 1;
		} else if (rest == 1) {
			checksum = 0;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}
}
