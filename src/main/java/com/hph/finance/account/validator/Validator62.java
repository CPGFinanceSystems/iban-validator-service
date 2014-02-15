package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2 }, posFrom = 3, posTo = 7, posChecksum = 8)
public class Validator62 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		Integer sum = sumRightLeft(accountNumber.getExtracted(), weights, true);
		int checksum = modulus - Integer.parseInt(last(sum.toString()));

		return checksum == accountNumber.getChecksumAsInt();
	}

}
