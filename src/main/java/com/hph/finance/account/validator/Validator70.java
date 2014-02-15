package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 2, 3, 4 })
public class Validator70 extends Validator06 {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (extract(accountNumber.getZeroFilled(), 4).equals("5")
				|| extract(accountNumber.getZeroFilled(), 4, 5).equals("69")) {
			weights[6] = 0;
			weights[7] = 0;
			weights[8] = 0;
		}

		return super.validate(accountNumber);
	}

}
