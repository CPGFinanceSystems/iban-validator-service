package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 1, 2, 1, 2, 1, 2, 1, 2, 1 })
public class Validator57V4 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (accountNumber.getZeroFilled().equals("0185125434")) {
			return true;
		}

		int first = Integer.parseInt(zeroTrimFront(extract(
				accountNumber.getZeroFilled(), 3, 4)));
		int second = Integer.parseInt(zeroTrimFront(extract(
				accountNumber.getZeroFilled(), 7, 9)));

		return first > 0 && first < 13 && second < 500;
	}

}
