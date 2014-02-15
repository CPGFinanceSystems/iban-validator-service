package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 })
public class Validator74 extends Validator00 {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		boolean isValid = super.validate(accountNumber);

		if (!isValid
				&& zeroTrimFront(accountNumber.getZeroFilled()).length() == 6) {

			Integer sum = sumRightLeft(accountNumber.getExtracted(), weights,
					true);
			Integer checksum = getHalfDecade(sum) - sum;

			return checksum == accountNumber.getChecksumAsInt();
		}

		return isValid;
	}
}
