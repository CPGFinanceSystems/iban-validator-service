package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 8 }, posFrom = 3, posTo = 9, posChecksum = 10)
public class Validator51MCA1 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int rest = sum % modulus;
		int checksum = modulus - rest;

		if (rest == 0 || rest == 1) {
			checksum = 0;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}
}
