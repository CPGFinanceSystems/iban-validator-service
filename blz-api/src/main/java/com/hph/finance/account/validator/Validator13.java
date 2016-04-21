package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

/**
 * TODO: Review & Verify
 * 
 * @author Hans-Peter Herzog <hpherzog@cdn-hph.de>
 * 
 */

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1 }, posFrom = 2, posTo = 7, posChecksum = 8)
public class Validator13 extends Validator00 {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		boolean isValid = super.validate(accountNumber);

		if (!isValid) {
			isValid = super.validate(prepare(accountNumber.getRawNumber()
					+ "00", accountNumber.getBankNumber()));
		}

		return isValid;
	}
}
