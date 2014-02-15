package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 2, 3, 4 })
public class Validator56 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeft(accountNumber.getExtracted(), weights);
		int rest = sum % modulus;
		int checksum = modulus - rest;

		boolean isNine = extract(accountNumber.getZeroFilled(), 1).equals("9");

		if ((checksum == 10 || checksum == 11) && !isNine) {
			return false;
		} else if (checksum == 10 && isNine) {
			checksum = 7;
		} else if (checksum == 11 && isNine) {
			checksum = 8;
		}

		return checksum == accountNumber.getChecksumAsInt();
	}

}
