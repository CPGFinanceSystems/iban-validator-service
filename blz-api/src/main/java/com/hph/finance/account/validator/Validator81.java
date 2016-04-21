package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7 })
public class Validator81 extends Validator32 {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int third = Integer.parseInt(extract(accountNumber.getZeroFilled(), 3));
		if (third == 9) {

			Validator51MC validator51MC = new Validator51MC();
			return validator51MC.validateException(accountNumber);

		}

		return super.validate(accountNumber);
	}
}
