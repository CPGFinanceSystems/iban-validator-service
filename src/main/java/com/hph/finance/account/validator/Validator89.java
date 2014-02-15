package com.hph.finance.account.validator;

import com.hph.finance.account.PreparedAccountNumber;
import com.hph.finance.account.Validator;
import com.hph.finance.account.ValidatorData;

@ValidatorData(modulus=11, weights={2, 3, 4, 5, 6, 7}, posFrom=4, posTo=9, posChecksum=10)
public class Validator89 extends Validator {

	@Override
	protected boolean validate(PreparedAccountNumber accountNumber) {
		
		if(accountNumber.getLength() == 8 || accountNumber.getLength() == 9) {
			Validator validator = new Validator10();
			return validator.isValid(accountNumber.getRawNumber(), accountNumber.getBankNumber());
		}
		
		if(accountNumber.getLength() == 7) {
		
			Integer sum = sumRightLeft(accountNumber.getExtracted(), weights, true);
			Integer rest = sum % modulus;
			Integer checksum = modulus - rest;

			if (rest == 0) {
				checksum = 0;
			} else if (rest == 1) {
				String sumStr = checksum.toString();
				checksum = Integer.parseInt(last(sumStr));
			}

			return checksum == accountNumber.getChecksumAsInt();			
		}
		
		return false;
	}

}
