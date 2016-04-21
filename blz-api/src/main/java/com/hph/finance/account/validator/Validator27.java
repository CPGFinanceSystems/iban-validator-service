package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 10, weights = { 2, 1, 2, 1, 2, 1, 2, 1, 2 }, transTable = {
		0, 1, 5, 9, 3, 7, 4, 8, 2, 6, 0, 1, 7, 6, 9, 8, 3, 2, 5, 4, 0, 1, 8, 4,
		6, 2, 9, 5, 7, 3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, transTableRows = { 1,
		4, 3, 2, 1, 4, 3, 2, 1 })
public class Validator27 extends Validator00 {

	protected boolean validate(PreparedAccountNumber accountNumber) {

		long number = accountNumber.getRawNumberAsLong();
		int checksum = accountNumber.getChecksumAsInt();

		if (number > 0 && number < 1000000000) {
			return super.validate(accountNumber);
		} else {
			String last = last(Integer.toString(sumTransform(
					accountNumber.getExtracted(), transTable, transTableRows)));
			int sum = modulus - Integer.parseInt(last);
			return sum == checksum;
		}
	}
}
