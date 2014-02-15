package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 1, 2, 0, 1, 2, 1, 2, 1, 2, 1 }, posTo = -1, posChecksum = 3)
public class Validator57V2 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		String number = accountNumber.getExtracted();
		int last = accountNumber.getChecksumAsInt();

		Integer sum = sumLeftRight(number, weights, true);
		int checksum = modulus - Integer.parseInt(last(sum.toString()));

		if (checksum == modulus) {
			checksum = 0;
		}

		return checksum == last;
	}

}
