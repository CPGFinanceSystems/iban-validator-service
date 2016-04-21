package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

/**
 * TODO: Review & Verify
 * 
 * @author Hans-Peter Herzog <hpherzog@cdn-hph.de>
 * 
 */

@ValidatorData(modulus = 11, weights = { 2, 3, 4, 5, 6, 7, 2 }, posFrom = 1, posTo = 7, posChecksum = 8)
public class Validator26 extends Validator06 {

	@Override
	protected PreparedAccountNumber prepare(String accountNumber,
			String bankNumber) {

		if (accountNumber.startsWith("00")) {

			String debugMessage = "Shift zeros: " + accountNumber;
			accountNumber = extract(accountNumber, 3, -1) + "00";
			debugMessage += " => " + accountNumber;
			logger.debug(debugMessage);
		}

		PreparedAccountNumber number = super.prepare(accountNumber, bankNumber);

		return number;
	}
}
