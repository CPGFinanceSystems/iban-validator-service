package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6 })
public class Validator82 extends Validator33 {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (extract(accountNumber.getZeroFilled(), 3, 4).equals("99")) {

			Validator validator = new Validator10();
			return validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber());
		}

		return super.validate(accountNumber);
	}

}
