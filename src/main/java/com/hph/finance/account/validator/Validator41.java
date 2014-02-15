package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 })
public class Validator41 extends Validator00 {

	protected PreparedAccountNumber prepare(String accountNumber,
			String bankNumber) {

		if (extract(zeroFill(accountNumber, length), 4).equals("9")) {
			accountNumber = "000" + extract(accountNumber, 4, -1);
		}

		return super.prepare(accountNumber, bankNumber);
	}
}
