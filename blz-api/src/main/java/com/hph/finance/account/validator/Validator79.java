package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 }, posFrom = 1, posTo = 9, posChecksum = 10)
public class Validator79 extends Validator00 {

	protected PreparedAccountNumber prepare(String accountNumber,
			String bankNumber) {

		int first = extractAsInt(zeroFill(accountNumber, length), 1);

		if (first == 1 || first == 2 || first == 9) {
			posTo = 8;
			posChecksum = 9;
		}

		return super.prepare(accountNumber, bankNumber);
	}
}
