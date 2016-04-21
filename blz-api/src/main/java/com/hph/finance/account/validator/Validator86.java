package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData
public class Validator86 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {

		int third = Integer.parseInt(extract(accountNumber.getZeroFilled(), 3));
		if (third == 9) {

			Validator51MC validator51MC = new Validator51MC();
			return validator51MC.validateException(accountNumber);

		}

		Validator validator = new Validator86MA();
		if (!validator.isValid(accountNumber.getRawNumber(),
				accountNumber.getBankNumber())) {

			validator = new Validator86MB();
			return validator.isValid(accountNumber.getRawNumber(),
					accountNumber.getBankNumber());
		}

		return true;
	}

}
