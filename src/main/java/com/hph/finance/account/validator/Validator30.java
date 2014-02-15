package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 0, 0, 0, 0, 1, 2, 1, 2 })
public class Validator30 extends Validator {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();
		Integer last = accountNumber.getChecksumAsInt();

		Integer sum = sumLeftRight(number, weights, false);
		Integer checksum = modulus - Integer.parseInt(last(sum.toString()));

		if (checksum == modulus) {
			checksum = 0;
		}

		return checksum == last;
	}
}
