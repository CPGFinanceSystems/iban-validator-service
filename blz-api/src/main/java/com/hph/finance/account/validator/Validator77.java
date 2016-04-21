package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 1, 2, 3, 4, 5 }, posFrom = 6, posTo = 10)
public class Validator77 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int sum = sumRightLeft(accountNumber.getExtracted(), weights);

		if ((sum % modulus) > 0) {

			Validator validator = new Validator77V2();
			return validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber());
		}

		return true;
	}

}
