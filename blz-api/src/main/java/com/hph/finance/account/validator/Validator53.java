package com.hph.finance.account.validator;

import com.hph.finance.account.MissingBankNumberException;
import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus = 11, weights = { 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4 })
public class Validator53 extends Validator {

	protected PreparedAccountNumber prepare(String accountNumber,
			String bankNumber) {

		if(bankNumber == null || bankNumber.equals("")) {
			throw new MissingBankNumberException();
		}		
		
		String eser = extract(bankNumber, -4, -3) + extract(accountNumber, 2)
				+ extract(bankNumber, -1) + extract(accountNumber, 1)
				+ extract(accountNumber, 3)
				+ zeroTrimFront(extract(accountNumber, 4, -1));

		PreparedAccountNumber number = super.prepare(accountNumber, bankNumber);
		number.setEser(eser);
		number.setEserExtracted(extract(eser, 1, 5) + "0"
				+ extract(eser, 7, -1));
		number.setChecksum(extract(eser, 6));
		return number;
	}

	protected boolean validate(PreparedAccountNumber accountNumber) {

		if (extract(accountNumber.getRawNumber(), 1).equals("9")
				&& accountNumber.getRawNumber().length() == 10) {
			Validator20 validator20 = new Validator20();
			return validator20.isValid(accountNumber.getRawNumber());
		}

		int sum = sumRightLeft(accountNumber.getEserExtracted(), weights);
		int rest = sum % modulus;

		int checksum = 0;
		for (int i = 0; i < 10; i++) {
			int tmpRest = (rest + i * 7) % modulus;
			if (tmpRest == 10) {
				checksum = i;
				break;
			}
		}

		return checksum == accountNumber.getChecksumAsInt();
	}
}
