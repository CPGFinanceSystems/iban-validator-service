package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = {2, 1, 2, 1, 2, 1, 2, 1, 2})
public class ValidatorD7 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		int sum = sumRightLeft(accountNumber.getExtracted(), weights, true);
		int checksum = extractAsInt(sum, -1);

		return checksum == accountNumber.getChecksumAsInt();
	}

}
